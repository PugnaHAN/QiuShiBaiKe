package com.hp.qiushibaike;

import android.app.Application;

import com.hp.qiushibaike.utils.LogUtils;

/**
 * Created by zhangjuh on 2016/3/14.
 */
public class MyApplication extends Application {
    private static final String TAG = LogUtils.makeLogTag(MyApplication.class);

    private static MyApplication sInstance;

    public static MyApplication getInstance(){
        if(sInstance == null){
            sInstance = new MyApplication();
        }
        return sInstance;
    }
}
