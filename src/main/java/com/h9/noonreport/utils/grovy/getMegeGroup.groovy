package com.h9.noonreport.utils.grovy

import cn.hutool.json.JSONObject
import com.h9.noonreport.entity.NoonReport
import com.h9.noonreport.vo.MergeGroupVo


/**
 * remarksSoms 规则
 * @param data
 * @param resultMap
 * @param code
 * @return
 */

def remarksSoms(List<JSONObject> data, HashMap resultMap, String code, NoonReport firstReport) {

    def dataCode = "timeZone"
    List<MergeGroupVo> mergeGroupPoList = new ArrayList<>();

    for (int i = 0; i < data.size(); i++) {
        MergeGroupVo mergeGroupVo = new MergeGroupVo();
        mergeGroupPoList.add(mergeGroupVo);
        def dataObj = data.get(i)
        Integer timeZone = dataObj.getInt(dataCode);
        mergeGroupVo.setStartIndex(i);
        mergeGroupVo.setTimeZone(timeZone);
        for (int j = i; j < data.size(); j++) {
            def endDataObj = data.get(j)
            Integer endTimeZone = endDataObj.getInt(dataCode);
            mergeGroupVo.setEndIndex(j);
            if (timeZone==endTimeZone) {
                if (j == data.size() - 1) {
                    i=j;
                    break;
                }
            } else {
                //i++ 与j++ 减2次
                i = j-1;
                break;
            }

        }

    }

    MergeGroupVo start = mergeGroupPoList.get(0);
    MergeGroupVo end = mergeGroupPoList.get(mergeGroupPoList.size()-1);
    Integer startTimeZone = start.getTimeZone();
    Integer endTimeZone = end.getTimeZone();
    if (10<=startTimeZone&&startTimeZone<=12){
        if (-12<=endTimeZone&&endTimeZone<=-10){
            resultMap.put(code,"Cross the date line eastward")
        }
    }else if (-12<=startTimeZone&&startTimeZone<=-10){
        if (10<=endTimeZone&&endTimeZone<=12){
            resultMap.put(code,"Cross the date line westward")
        }
    }

}

