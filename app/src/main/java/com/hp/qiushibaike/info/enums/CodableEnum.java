package com.hp.qiushibaike.info.enums;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public interface CodableEnum {
    /**
     * This method is used to return the enum value by given code
     * @param Code
     * @return enum
     */
    CodableEnum getByCode(String Code);
}
