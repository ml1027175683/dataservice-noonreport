package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import com.h9.noonreport.entity.NoonReport


/**
 * meWork 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def meWork(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {

    def MapCode = "shaftPower"
    def timestamp = "timestamp"
    BigDecimal sumData = new BigDecimal(0);
    for (int i = 0; i < data.size(); i++) {
        if (i == 0) {
            Double adouble = data.get(i).getDouble(MapCode);
            if (!Objects.isNull(adouble)) {
                BigDecimal bdouble = new BigDecimal(adouble).multiply(new BigDecimal(5 / 60));
                sumData = sumData.add(bdouble);
            }

        }
        if (i > 0 && i < data.size() - 1) {
            JSONObject perData = data.get(i - 1);
            JSONObject currentData = data.get(i);
            Long perTimestamp = perData.getLong(timestamp);
            Double cDouble = currentData.getDouble(MapCode);
            Long currentTimestamp = currentData.getLong(timestamp);
            double fiveMin = (currentTimestamp - perTimestamp) / 3600d;
            if (!Objects.isNull(cDouble)) {
                BigDecimal res = new BigDecimal(cDouble).multiply(new BigDecimal(fiveMin)).divide(new BigDecimal(0.97),12,BigDecimal.ROUND_HALF_UP);
                sumData = sumData.add(res);
            }


        }
    }
    resultMap.put(code, sumData.doubleValue())

}

