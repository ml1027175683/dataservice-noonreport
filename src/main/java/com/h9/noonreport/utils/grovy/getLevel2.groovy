package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import cn.hutool.json.JSONUtil
import com.h9.noonreport.constant.WaveScaleLevel
import com.h9.noonreport.entity.NoonReport


/**
 * waveScale 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def waveScale(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {

    def obj = JSONUtil.parseObj(resultMap)
    def aDouble = obj.getDouble("wave_scale")
    if (!Objects.isNull(aDouble)) {
        def level = WaveScaleLevel.getLevel(aDouble)
        resultMap.put(code,level)

    }

}

