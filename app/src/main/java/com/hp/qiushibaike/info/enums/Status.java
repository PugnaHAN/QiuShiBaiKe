package com.hp.qiushibaike.info.enums;

import java.util.HashMap;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public enum Status implements CodableEnum {
    /*
     * 错误和未知的糗事状态
     */
    UNKNOWN("unknown"),
    /*
     * 糗事通过
     */
    PUBLISH("publish"),
    /*
     * 糗事正在审核
     */
    ACTIVE("active"),
    /*
     * 糗事未通过
     */
    BONDED("bonded");

    public String status;

    Status(String sts){
        status = sts;
    }

    @Override
    public Status getByCode(String code){
        return (Status)CodableEnumHelper.getByCode(code, values());
    }

    @Override
    public String toString(){
        return status;
    }
}
