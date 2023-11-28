package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import cn.hutool.json.JSONUtil
import com.h9.noonreport.entity.NoonReport

/**
 * steamingTime 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def steamingTime(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {
    int realData = 0;
    for (JSONObject obj : data) {
        def aDouble = obj.getDouble("speedKnots")
        if (!Objects.isNull(aDouble)) {
            if (aDouble <= 3) {
                realData++;
            }
        }
    }

    def fiveMin = 5 / 60
    Double value = realData* fiveMin

    def obj = JSONUtil.parseObj(resultMap)
    Double aDouble = obj.getDouble("report_length_hrs")


    if (!Objects.isNull(aDouble)) {

        def doubleValue = new BigDecimal(aDouble).subtract(new BigDecimal(value)).doubleValue()
        resultMap.put(code, doubleValue) ;
    }
}