package com.h9.noonreport.constant;

public enum WaveScaleLevel {
        LEVEL0(0,0.0,0.0),
        LEVEL1(1,0.0,0.1),
        LEVEL2(2,0.1,0.5),
        LEVEL3(3,0.5,1.3),
        LEVEL4(4,1.3,2.5),
        LEVEL5(5,2.5,4.0),
        LEVEL6(6,4.0,6.0),
        LEVEL7(7,6.0,9.0),
        LEVEL8(8,9.0,14.0),
        LEVEL9(9,14.0,666666.0),
    ;
    Integer level;
    Double min;
    Double max;

    WaveScaleLevel(Integer level, Double min, Double max) {
        this.level = level;
        this.min = min;
        this.max = max;
    }

    public static Integer getLevel(Double data) {
        for (WaveScaleLevel freezeType : WaveScaleLevel.values()) {
            if (data==0){
                return 0;
            } else if (data>0&&data<0.1) {
                return 1;
            }else {
                Double minDouble = freezeType.min;
                Double maxDouble = freezeType.max;
                if (data >= minDouble && data < maxDouble) {
                    return freezeType.level;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getLevel(5d));
    }

}
