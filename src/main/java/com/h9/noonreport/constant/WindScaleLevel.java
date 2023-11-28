package com.h9.noonreport.constant;

public enum WindScaleLevel {
        LEVEL0(0,0.0,0.3),
        LEVEL1(1,0.3,1.6),
        LEVEL2(2,1.6,3.4),
        LEVEL3(3,3.4,5.5),
        LEVEL4(4,5.5,8.0),
        LEVEL5(5,8.0,10.8),
        LEVEL6(6,10.8,13.9),
        LEVEL7(7,13.9,17.2),
        LEVEL8(8,17.2,20.8),
        LEVEL9(9,20.8,24.5),
        LEVEL10(10,24.5,28.5),
        LEVEL11(11,28.5,32.7),
        LEVEL12(12,32.7,37.0),
        LEVEL13(13,37.0,41.5),
        LEVEL14(14,41.5,46.2),
        LEVEL15(15,46.2,51.0),
        LEVEL16(16,51.0,56.1),
        LEVEL17(17,56.1,61.3),
        LEVEL18(18,61.3,69.4),
        LEVEL19(19,69.4,99999.0),



    ;
    Integer level;
    Double min;
    Double max;

    WindScaleLevel(Integer level, Double min, Double max) {
        this.level = level;
        this.min = min;
        this.max = max;
    }

    public static Integer getLevel(Double data) {
        for (WindScaleLevel freezeType : WindScaleLevel.values()) {
            Double minDouble = freezeType.min;
            Double maxDouble = freezeType.max;
            if (data >= minDouble && data < maxDouble) {
                return freezeType.level;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(getLevel(5d));
    }

}
