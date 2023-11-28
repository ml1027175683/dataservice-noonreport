package com.h9.noonreport.service.impl;


import cn.hutool.json.JSONUtil;
import com.h9.noonreport.mapper.NoonReportMapper;
import com.h9.noonreport.service.INoonReportService;
import com.h9.noonreport.utils.DateUtils;
import com.h9.noonreport.vo.NoonReportVo;
import com.h9.noonreport.entity.NoonReport;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 午报数据表 服务实现类
 * </p>
 *
 * @author 9h
 * @since 2023-11-15
 */
@Service
public class NoonReportServiceImpl extends ServiceImpl<NoonReportMapper, NoonReport> implements INoonReportService {

    @Override
    public NoonReportVo getNoonReportById(Long id) {
        NoonReport noonReport = this.getById(id);
        Map bean = JSONUtil.toBean(JSONUtil.parseObj(noonReport.getReportMsg()), Map.class);
        NoonReportVo noonReportVo = new NoonReportVo();
        BeanUtils.copyProperties(noonReport,noonReportVo);
        noonReportVo.setReportData(bean);
        noonReportVo.setCreateTime(DateUtils.getDateFormat(noonReport.getCtime()));
        return noonReportVo;
    }
}
