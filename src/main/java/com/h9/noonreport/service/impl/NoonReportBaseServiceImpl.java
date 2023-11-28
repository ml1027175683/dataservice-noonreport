package com.h9.noonreport.service.impl;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.h9.noonreport.constant.DealLanguage;
import com.h9.noonreport.constant.RedisConstants;
import com.h9.noonreport.dto.NoonReportNowDateSomsDto;
import com.h9.noonreport.entity.*;
import com.h9.noonreport.service.*;
import com.h9.noonreport.utils.DateUtils;
import com.h9.noonreport.utils.GroovyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class NoonReportBaseServiceImpl implements INoonReportBaseService {

    @Resource
    private ThreadPoolTaskExecutor noonReportDealTaskExecutor;

    @Resource
    private RedisTemplate redisTemplateDB10;

    @Resource
    private IShipInfoService shipInfoService;

    @Resource
    private IShipOrgDictService shipOrgDictService;

    @Resource
    private IDictConfigService dictConfigService;

    @Resource
    private IRuleConfigService ruleConfigService;

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private INoonReportService noonReportService;

    @Resource
    private IShipSupplementService supplementService;

    @Value("${wash.data.getApiIp}")
    String apiIp;

    @Value("${wash.data.getNowTimeUrl}")
    String getNowTimeUrl;
    @Value("${wash.data.getSomsNoonReportData}")
    String getSomsNoonReportData;

    @Override
    public void dealNoonReport() {
        List<ShipInfo> shipInfos = getShipInfos();
        for (ShipInfo shipInfo : shipInfos) {
            try {
                Long timestamp = getTimestamp(shipInfo.getShipCode());
                getReoprt(shipInfo, timestamp);
            } catch (Exception e) {
                log.info("failed del shipData shipCode:{}", shipInfo.getShipCode());
            }
        }
    }

    @Override
    public void dealNoonReport(Long timestamp,String shipCode) {
        ShipInfo shipInfo = getShipInfo(shipCode);
        try {
            getReoprt(shipInfo, timestamp);
        } catch (Exception e) {
            log.info("failed del shipData shipCode:{}", shipInfo.getShipCode());
        }
    }




    @Override
    public void deal7daysNoonReport() {
        List<ShipInfo> shipInfos = getShipInfos();
        for (ShipInfo shipInfo : shipInfos) {
            String shipCode = shipInfo.getShipCode();
            try {
                ArrayList<Long> times = getTimes(shipCode);
                for (Long timestamp : times) {
                    getReoprt(shipInfo, timestamp);
                }

            } catch (Exception e) {
                log.info("failed del shipData shipCode:{}", shipCode);
            }
        }
    }


    private List<ShipInfo> getShipInfos() {
        QueryWrapper<ShipInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ShipInfo::getIsEnable,0);
        List<ShipInfo> shipInfos = shipInfoService.list(queryWrapper);
        return shipInfos;
    }
    private ShipInfo getShipInfo(String shipCode) {
        QueryWrapper<ShipInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ShipInfo::getShipCode, shipCode)
                .eq(ShipInfo::getIsEnable,0).last("limit 1");
        ShipInfo shipInfo = shipInfoService.getOne(queryWrapper);
        return shipInfo;
    }

    private ArrayList<Long> getTimes(String shipCode) {
        ArrayList<Long> times = new ArrayList<>();
        Object obj = redisTemplateDB10.opsForValue().get(RedisConstants.NOONREOPRT_GENERATE + shipCode);
        if (Objects.isNull(obj)) {
            return times;
        }
        Long timestamp  = Long.valueOf(String.valueOf(obj)) ;
        //7天前
        Long offsetTime = Long.valueOf(60 * 60 * 12*2*7);
        long daysOf7timestamp = timestamp - offsetTime;

        for (int i = 0; i < 2 * 7; i++) {
            long addTimestamp = daysOf7timestamp + (i * 60 * 60 * 12);
            times.add(addTimestamp);
        }
        return times;
    }

    private void getReoprt(ShipInfo shipInfo, Long timestamp) {
        NoonReportNowDateSomsDto noonReportNowDateDto = getNoonReportNowDateSomsDto(shipInfo.getShipCode(), timestamp);
        if (!Objects.isNull(noonReportNowDateDto)) {
            String localDate = noonReportNowDateDto.getLocalDate();

            String localTime = noonReportNowDateDto.getLocalTime();
            boolean delFlag = Boolean.FALSE;
            Date formatDate = DateUtils.getDateByFormat(localTime, DateUtils.YYYYMMDDHHMMSS2);
            Long timeLong = Long.valueOf(DateUtils.getFormatByDate(formatDate, DateUtils.HHmm));
            if (timeLong >= 1200 && timeLong < 2359) {
                delFlag = Boolean.TRUE;

            }
            if (delFlag) {
                delNoonReport(shipInfo, noonReportNowDateDto, localDate, formatDate);
            }


        }
    }

    private void delNoonReport(ShipInfo shipInfo, NoonReportNowDateSomsDto noonReportNowDateDto, String localDate, Date formatDate) {
        String shipCode = shipInfo.getShipCode();
        Long shipId = shipInfo.getId();


        String localTime2 = localDate + " 12:00:00";
        Date noonTime = DateUtils.getDateByFormat(localTime2, DateUtils.YYYYMMDDHHMMSS2);
        //时间偏移量
        long offset = formatDate.getTime() / 1000 - noonTime.getTime() / 1000;
        Long endTime = noonReportNowDateDto.getTimestamp();
        //往前推25小时
        long startTime = endTime - 90000;
        if (offset > 0) {
            startTime = startTime - offset;
            endTime = endTime - offset;
        }
        String result = getResult(shipCode, endTime, startTime);
        try {
            if (!Objects.isNull(result)) {
                JSONArray data = JSONUtil.parseObj(result).getJSONArray("data");
                Integer startIndex = getStartIndex(data);
                Integer endIndex = getendIndex(data);
                if (!Objects.isNull(startIndex) && !Objects.isNull(endIndex)) {
                    JSONObject startData = data.getJSONObject(startIndex);
                    JSONObject endData = data.getJSONObject(endIndex);
                    String timeZone = endData.getStr("timeZone");
                    String reportDate = endData.getStr("localDate");
                    //前一条午报数据集
                    NoonReport firstReport = getFirstReport(shipCode, endData);
                    //获取配置集
                    List<DictConfig> dictConfigs = getDictConfigs(shipId);
                    //取正确数据集
                    ArrayList<JSONObject> dataList = getDataList(data, startIndex, endIndex);
                    System.out.println(JSONUtil.toJsonStr(dataList));
                    //结果集
                    HashMap<String, Object> resultMap = initRresultMap(shipCode);
                    //处理逻辑
                    dealData(firstReport, dictConfigs, dataList, resultMap);
                    //保存与更新
                    saveNoonReport(shipCode, startData, endData, timeZone, reportDate, resultMap);

                }

            }
        } catch (Exception e) {
            log.info("failed getSomsNoonReportData shipCode:{},startTime:{},endTime:{},result:{}", shipCode, startTime, endTime, result);
        }
    }

    private void dealData(NoonReport firstReport, List<DictConfig> dictConfigs, ArrayList<JSONObject> dataList, HashMap<String, Object> resultMap) {
        for (DictConfig dictConfig : dictConfigs) {
            Long id = dictConfig.getId();
            String code = dictConfig.getCode();
            RuleConfig ruleConfig = ruleConfigService.getById(id);
            if (!Objects.isNull(ruleConfig)) {
                Integer dealType = ruleConfig.getDealType();
                if (DealLanguage.GROOVY.getDealType() == dealType) {
                    try {
                        GroovyUtil.engine(ruleConfig.getFuncName(), ruleConfig.getGroovyBody(), dataList, resultMap, code, firstReport);
                    } catch (Exception e) {
                        log.info("erro deal:ruleConfig:{} erroMsg:{}", ruleConfig, e.getMessage());
                    }

                }

            }

        }
    }

    private List<DictConfig> getDictConfigs(Long shipId) {
        //获取船舶配置
        List<ShipOrgDict> shipOrgDicts = getShipOrgDicts(shipId);
        List<Long> dictIds = shipOrgDicts.stream()
                .map(ShipOrgDict::getDictId)
                .collect(Collectors.toList());

        List<DictConfig> dictConfigs = dictConfigService.listByIds(dictIds);
        Collections.sort(dictConfigs, Comparator.comparingLong(DictConfig::getLevel));
        return dictConfigs;
    }

    private HashMap<String, Object> initRresultMap(String shipCode) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //init resultMap
        QueryWrapper<ShipSupplement> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ShipSupplement::getShipCode, shipCode);
        List<ShipSupplement> list = supplementService.list(queryWrapper);
        for (ShipSupplement shipSupplement : list) {
            String key = shipSupplement.getNoonreportKey();
            String value = shipSupplement.getNoonreportValue();
            //添加增补key值
            resultMap.put(key, value);
        }
        return resultMap;
    }

    private NoonReport getFirstReport(String shipCode, JSONObject endData) {
        QueryWrapper<NoonReport> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(NoonReport::getShipCode, shipCode).lt(NoonReport::getEndTimestamp, endData.getLong("timestamp")).orderByDesc(NoonReport::getEndTimestamp).last("limit 1");
        NoonReport firstReport = noonReportService.getOne(queryWrapper);
        return firstReport;
    }

    private void saveNoonReport(String shipCode, JSONObject startData, JSONObject endData, String timeZone, String reportDate, HashMap<String, Object> resultMap) {
        QueryWrapper<NoonReport> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(NoonReport::getShipCode, shipCode)
                .eq(NoonReport::getTimeZone, timeZone).eq(NoonReport::getReportDate, reportDate);
        NoonReport noonReport = noonReportService.getOne(queryWrapper);

        saveOrUpdateNoonReport(shipCode, startData, endData, timeZone, reportDate, resultMap, noonReport);
    }

    private void saveOrUpdateNoonReport(String shipCode, JSONObject startData, JSONObject endData, String timeZone, String reportDate, HashMap<String, Object> resultMap, NoonReport noonReport) {
        String reportMsg = JSONUtil.toJsonStr(JSONUtil.parseObj(resultMap));
        if (!Objects.isNull(noonReport)) {
            noonReport.setReportMsg(reportMsg);
        } else {
            noonReport = new NoonReport();
            noonReport.setShipCode(shipCode);
            noonReport.setStartTimestamp(startData.getLong("timestamp"));
            noonReport.setEndTimestamp(endData.getLong("timestamp"));
            noonReport.setTimeZone(timeZone);
            noonReport.setReportDate(reportDate);
            noonReport.setReportMsg(reportMsg);
            noonReport.setCtime(new Date());
        }
        noonReportService.saveOrUpdate(noonReport);
        redisTemplateDB10.opsForValue().set(RedisConstants.NOONREOPRT_GENERATE+shipCode,endData.getLong("timestamp"));
    }

    private String getResult(String shipCode, Long endTime, long startTime) {
        HashMap<String, Object> parms = new HashMap<>();
        parms.put("shipCode", shipCode);
        parms.put("startTime", startTime);
        parms.put("endTime", endTime);
        String result = HttpUtil.createPost(apiIp + getSomsNoonReportData).body(JSONUtil.toJsonStr(parms), ContentType.JSON.getValue()).execute().body();
        return result;
    }

    private Long getTimestamp(String shipCode) {
        Long timestamp = new Date().getTime() / 1000;

        Sort sort = Sort.by(Sort.Direction.DESC, "timestamp");
        Query query = new Query().with(sort);
        query.limit(1);
        Map oneLatest = mongoTemplate.findOne(query, Map.class, shipCode);


        if (!Objects.isNull(oneLatest)) {
            timestamp = Long.valueOf(String.valueOf(oneLatest.get("timestamp")));

        }
        return timestamp;
    }

    private List<ShipOrgDict> getShipOrgDicts(Long shipId) {
        QueryWrapper<ShipOrgDict> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(ShipOrgDict::getShipId, shipId);
        List<ShipOrgDict> shipOrgDicts = shipOrgDictService.list(queryWrapper);
        return shipOrgDicts;
    }

    private static ArrayList<JSONObject> getDataList(JSONArray data, Integer startIndex, Integer endIndex) {
        List<Object> needNoonData = data.subList(startIndex, endIndex + 1);
        ArrayList<JSONObject> dataList = new ArrayList<>();
        for (Object needNoonDatum : needNoonData) {
            dataList.add((JSONObject) needNoonDatum);
        }
        return dataList;
    }

    private static Integer getStartIndex(JSONArray data) {

        for (int i = 0; i < data.size(); i++) {
            JSONObject oobj = (JSONObject) data.get(i);
            String dataLocalTime = oobj.getStr("localTime");
            Date date = DateUtils.getDateByFormat(dataLocalTime, DateUtils.YYYYMMDDHHMMSS2);
            Long timeLong = Long.valueOf(DateUtils.getFormatByDate(date, DateUtils.HHmm));
            if (timeLong >= 1200) {
                return i;

            }

        }
        return null;
    }


    private static Integer getendIndex(JSONArray data) {

        for (int i = data.size() - 1; i > 0; i--) {
            JSONObject oobj = (JSONObject) data.get(i);
            String dataLocalTime = oobj.getStr("localTime");
            Date date = DateUtils.getDateByFormat(dataLocalTime, DateUtils.YYYYMMDDHHMMSS2);
            Long timeLong = Long.valueOf(DateUtils.getFormatByDate(date, DateUtils.HHmm));
            if (timeLong < 1200) {
                return i;
            }

        }
        return null;
    }


    private NoonReportNowDateSomsDto getNoonReportNowDateSomsDto(String shipCode, Long timestamp) {
        HashMap<String, Object> parms = new HashMap<>();
        parms.put("shipCode", shipCode);
        parms.put("timestamp", timestamp);
        String result = HttpUtil.createPost(apiIp + getNowTimeUrl).body(JSONUtil.toJsonStr(parms), ContentType.JSON.getValue()).execute().body();
        NoonReportNowDateSomsDto noonReportNowDateDto = null;
        try {
            if (!Objects.isNull(result)) {
                JSONObject data = JSONUtil.parseObj(result).getJSONObject("data");
                noonReportNowDateDto = JSONUtil.toBean(data, NoonReportNowDateSomsDto.class);
            }
        } catch (Exception e) {
            log.info("failed getNoonReportNowDate shipCode:{},timestamp:{},result:{}", shipCode, timestamp, result);
        }
        return noonReportNowDateDto;
    }


}
