package com.h9.noonreport.constant;


import lombok.Getter;

public enum DealLanguage {
    FORMULA(0, "formula"),
    GROOVY(1, "groovy"),
    PYTHON(2, "python"),
    LUA(3, "lua"),


    ;

    @Getter
    private Integer dealType;
    @Getter
    private String dealTypeDesc;

    DealLanguage(Integer dealType, String dealTypeDesc) {
        this.dealType = dealType;
        this.dealTypeDesc = dealTypeDesc;
    }

    public static String getDealtype(Integer id) {
        for (DealLanguage item : DealLanguage.values()) {
            if (item.dealType.equals(id)) {
                return item.dealTypeDesc;
            }
        }
        return id + "";
    }
}
