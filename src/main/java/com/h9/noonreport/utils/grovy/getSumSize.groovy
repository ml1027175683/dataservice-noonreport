package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import cn.hutool.json.JSONUtil
import com.h9.noonreport.entity.NoonReport


/**
 * getTotalFoConsMt 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def getTotalFoConsMt(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {
    def obj = JSONUtil.parseObj(resultMap)
    def aDouble = obj.getDouble("me_cons_mt")
    def bDouble = obj.getDouble("ae_cons_mt")
    def cDouble = obj.getDouble("boiler_cons_mt")
    if (!Objects.isNull(aDouble)&&!Objects.isNull(bDouble)&&!Objects.isNull(cDouble)) {
        def value = aDouble + bDouble + cDouble
        resultMap.put(code,value) ;
    }

}