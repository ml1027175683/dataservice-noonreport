package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import com.h9.noonreport.entity.NoonReport


/**
 * ae_no4_power 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def ae_no4_power(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {
    int realData = 0;
    for (JSONObject obj : data) {
        def aDouble = obj.getDouble("ae_no4_power")

        if (!Objects.isNull(aDouble) ) {
            if (aDouble >0) {
                realData++;
            }
        }
    }

    def fiveMin = 5 / 60
    resultMap.put(code,realData* fiveMin) ;
}