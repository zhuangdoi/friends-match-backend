package com.yupi.usercenter.model.enums;

/**
 * @author xiaozhuang
 * @creat 2023-08-09-16:32
 */
public enum TeamStatusEnum {

    PUBLIC(0,"公开"),
        PRIVATE(1,"私有"),
            SECRET(2,"加密");

    public static TeamStatusEnum getEnumByValue(Integer value){
        if (value == null){
            return null;
        }
        TeamStatusEnum[] values = TeamStatusEnum.values();
        for(TeamStatusEnum teamStatusEnum : values){
            if (teamStatusEnum.getValue() == value){
                return teamStatusEnum;
            }
        }
        return null;
    }


    private int value;
    private String text;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


     TeamStatusEnum(int value, String text) {
        this.value = value;
        this.text = text;
    }
}
