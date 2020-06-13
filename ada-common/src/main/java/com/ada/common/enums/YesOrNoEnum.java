package com.ada.common.enums;

public enum YesOrNoEnum {

    Y("Y", "是"),

    N("N", "否");

    private String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    YesOrNoEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
