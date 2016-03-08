package com.hp.qiushibaike.info.enums;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public class CodableEnumHelper {
    public static CodableEnum getByCode(String code, CodableEnum[] values){
        for(CodableEnum e : values){
            if(e.toString().equalsIgnoreCase(code)){
                return e;
            }
        }
        return null;
    }
}
