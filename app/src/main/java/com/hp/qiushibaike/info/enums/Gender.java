package com.hp.qiushibaike.info.enums;

import java.util.HashMap;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public enum Gender implements CodableEnum {
    MALE("M"),
    FEMALE("F"),
    UNKNOWN("U"),
    NONE("");

    private String gender;

    Gender(String g){
        gender = g;
    }

    @Override
    public Gender getByCode(String code){
        return (Gender)CodableEnumHelper.getByCode(code, values());
    }

    @Override
    public String toString(){
        return gender;
    }
}
