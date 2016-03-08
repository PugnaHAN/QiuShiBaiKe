package com.hp.qiushibaike.info;

import com.hp.qiushibaike.info.enums.Emotion;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public class UserDetail extends UserBasicObject {
    private static final String TAG = LogUtils.makeLogTag(UserDetail.class);

    public static final String JSON_EMOTION = "emotion";
    public static final String JSON_HOMETOWN = "hometown";
    public static final String JSON_HAUNT = "haunt";
    public static final String JSON_QB_AGE = "qb_age";
    public static final String JSON_ASTROLOGY = "astrology";
    public static final String JSON_MOBILE_BRAND = "mobile_brand";
    public static final String JSON_SMILE_COUNT = "smile_cnt";
    public static final String JSON_BIG_COVER = "big_cover";
    public static final String JSON_QS_COUNT = "qs_cnt";
    public static final String JSON_LOCATION = "location";
    public static final String JSON_HOBBY = "hobby";
    public static final String JSON_BG = "bg";
    public static final String JSON_RELATIONSHIP = "relationship";
    public static final String JSON_JOB = "job";
    public static final String JSON_GENDER = "gender";
    public static final String JSON_SIGNATURE = "signature";
    public static final String JSON_AGE = "age";

    private Emotion mEmotion;
    private String mHomeTown;
    private String mHaunt;
    private int mQbAge;


    @Override
    public JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        return json;
    }
}
