package com.h9.noonreport.utils;

import cn.hutool.script.ScriptUtil;

import javax.script.Invocable;
import javax.script.ScriptEngine;

public class GroovyUtil {

    public static Object engine(String functionName, String script, Object... variable) throws Exception {
        ScriptEngine scriptEngine = ScriptUtil.getGroovyEngine();
        scriptEngine.eval(script);
        Invocable invocable = (Invocable) scriptEngine;
        return invocable.invokeFunction(functionName, variable);
    }

}
