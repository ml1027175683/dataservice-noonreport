package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import com.h9.noonreport.entity.NoonReport


/**
 * windDiretionSoms 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def windDiretionSoms(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {

    ArrayList<JSONObject> redataList = new ArrayList<>();

    def dataCode = "windDirection"
    for (JSONObject jsonObject : data) {
        Double dataValue = jsonObject.getDouble(dataCode);
        if (!Objects.isNull(dataValue)) {
            println dataValue
            redataList.add(jsonObject);
        }
    }
    def totalValue = 0d;
    for (JSONObject obj : redataList) {
        Double dataValue = obj.getDouble(dataCode);
        totalValue+=dataValue;
    }
    if (redataList.size()>0){
        def value = totalValue / redataList.size()
        resultMap.put(code,value)
    }
}