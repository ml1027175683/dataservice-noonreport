package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import cn.hutool.json.JSONUtil
import com.h9.noonreport.entity.NoonReport

/**
 * getObservedSpeedNmH 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def getObservedSpeed_0_5kn(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {
    def obj = JSONUtil.parseObj(resultMap)
    def obsSpdkn = obj.getDouble("observed_speed_kn")
    if (!Objects.isNull(obsSpdkn)) {
            for (int i = 0; i < 51; i++) {
                double value = 0 + i * 0.5;
                double min = -0.25 + value;
                double max = 0.25 + value;
                if (obsSpdkn>=min&&obsSpdkn<max){
                    resultMap.put(code,value)
                    break;
                }
            }


    }


}

