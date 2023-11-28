package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import com.h9.noonreport.entity.NoonReport


/**
 * getDataByMin 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def getDataByMin(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {
    Double result=null;
    for (JSONObject obj : data) {
        def aDouble = obj.getDouble("me_cyl_7_exh_gas_out_temp")
        if (!Objects.isNull(aDouble)) {
            if (!Objects.isNull(result)){
                if (aDouble<result){
                    result=aDouble;
                }
            }else {
                result=aDouble;
            }
        }
    }

}