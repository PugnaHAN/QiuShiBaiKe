package com.hp.qiushibaike.utils;

import java.util.Random;

/**
 * Created by zhangjuh on 2016/3/7.
 */
public class IdUtils {
    private static final String TAG = LogUtils.makeLogTag(IdUtils.class);

    public static long generateId(){
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        return random.nextLong();
    }

    public static boolean isUnique(long id){
        // TODO: to check whether the Id is unique
        return id%2 == 0;
    }
}
