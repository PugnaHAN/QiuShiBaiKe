package com.hp.qiushibaike.info.enums;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public enum State implements CodableEnum {
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

    State(String sts){
        status = sts;
    }

    @Override
    public State getByCode(String code){
        return (State)CodableEnumHelper.getByCode(code, values());
    }

    @Override
    public String toString(){
        return status;
    }

    public static State decodeString(String s){
        return (State)CodableEnumHelper.getByCode(s, values());
    }
}
