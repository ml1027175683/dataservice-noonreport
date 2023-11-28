package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import com.h9.noonreport.entity.NoonReport

/**
 * observedSpeedRealtime 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def observedSpeedRealtime(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {
    resultMap.put(code,data.get(data.size()-1).getDouble("speedKnots"))
}