package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import cn.hutool.json.JSONUtil
import com.h9.noonreport.entity.NoonReport


/**
 * ae_no4_load 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def ae_no4_load(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {

    def MapCode1 = "ae_no4_power";
    def MapCode2 = "no4_dg_rated_power";
    def obj = JSONUtil.parseObj(resultMap)
    def aDouble = obj.getDouble(MapCode1)
    def bDouble = obj.getDouble(MapCode2)
    if (!Objects.isNull(aDouble) && !Objects.isNull(bDouble)) {
        resultMap.put(code, aDouble/bDouble)
    }


}

