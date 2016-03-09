package com.hp.qiushibaike.info.enums;

import java.util.HashMap;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public enum Type implements CodableEnum {
    HOT("hot"),
    PROMOTE("promote"),
    FRESH("fresh"),
    NONE("");

    public String type;

    Type(String tp){
        type = tp;
    }

    @Override
    public Type getByCode(String code){
        return (Type)CodableEnumHelper.getByCode(code, values());
    }

    @Override
    public String toString(){
        return type;
    }

    public static Type decodeString(String s){
        return (Type)CodableEnumHelper.getByCode(s, values());
    }
}
