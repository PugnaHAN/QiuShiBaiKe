package com.hp.qiushibaike.info.enums;

/**
 * Created by zhangjuh on 2016/3/9.
 */
public enum RelationShip implements CodableEnum{
    NO_RELATIONSHIP("no_rel"),
    FANS("fans"),
    OBSERVED("observed"),
    FRIENDS("friends");

    private String relationship;

    RelationShip(String r){
        relationship = r;
    }

    @Override
    public RelationShip getByCode(String code){
        return (RelationShip)CodableEnumHelper.getByCode(code, values());
    }

    @Override
    public String toString(){
        return relationship;
    }

    public static RelationShip decodeString(String s){
        return (RelationShip)CodableEnumHelper.getByCode(s, values());
    }
}
