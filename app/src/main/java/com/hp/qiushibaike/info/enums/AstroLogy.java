package com.hp.qiushibaike.info.enums;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public enum AstroLogy implements CodableEnum{
    CAPRICORN("摩羯座"),
    AQUARIUS("水瓶座"),
    PISCES("双鱼座"),
    ARIES("白羊座"),
    TAURUS("金牛座"),
    GEMINI("双子座"),
    CANCER("巨蟹座"),
    LEO("狮子座"),
    VIRGO("处女座"),
    LIBAR("天秤座"),
    SCORPIO("天蝎座"),
    SAGITTARIUS("射手座");

    private String astrology;

    AstroLogy(String ast){
        astrology = ast;
    }

    @Override
    public AstroLogy getByCode(String code){
        return (AstroLogy)CodableEnumHelper.getByCode(code, values());
    }

    @Override
    public String toString(){
        return astrology;
    }

    public static AstroLogy decodeString(String s){
        return (AstroLogy)CodableEnumHelper.getByCode(s, values());
    }
}
