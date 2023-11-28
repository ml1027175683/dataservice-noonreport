package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import com.h9.noonreport.entity.NoonReport


/**
 * getMeload 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */
def getMeload(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {

    ArrayList<JSONObject> redataList = new ArrayList<>();

    for (JSONObject jsonObject : data) {
        Double meLoadCal = jsonObject.getDouble("meLoadCal");
        if (!Objects.isNull(meLoadCal)) {
            redataList.add(jsonObject);
        }
    }
    def totalMeLoadCal = 0d;
    for (JSONObject obj : redataList) {
        Double meLoadCal = obj.getDouble("meLoadCal");
        totalMeLoadCal+=meLoadCal;
    }
    if (redataList.size()>0){
        def value = totalMeLoadCal / redataList.size()
        resultMap.put(code,value)
    }


}