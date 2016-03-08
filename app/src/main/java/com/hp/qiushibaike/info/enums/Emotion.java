package com.hp.qiushibaike.info.enums;

import java.util.HashMap;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public enum Emotion implements CodableEnum{
    SINGLE("single"),
    MARRIED("married"),
    SECRET("secret"),
    NONE("");

    public String emotion;

    Emotion(String emt){
        emotion = emt;
    }

    @Override
    public Emotion getByCode(String code){
        return (Emotion)CodableEnumHelper.getByCode(code, values());
    }

    @Override
    public String toString(){
        return emotion;
    }
}
