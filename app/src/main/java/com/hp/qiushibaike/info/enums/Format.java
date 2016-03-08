package com.hp.qiushibaike.info.enums;

import java.util.HashMap;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public enum Format implements CodableEnum{
    WORD("word"),
    IMAGE("image"),
    VIDEO("video"),
    UKNOWN("unknown");

    public String format;

    Format(String fmt){
        format = fmt;
    }

    @Override
    public Format getByCode(String code){
        return (Format) CodableEnumHelper.getByCode(code, values());
    }

    @Override
    public String toString(){
        return format;
    }
}
