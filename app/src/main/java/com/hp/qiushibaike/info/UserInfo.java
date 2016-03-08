package com.hp.qiushibaike.info;

import com.hp.qiushibaike.info.enums.Gender;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class UserInfo extends UserBasicObject {
    private static final String TAG = LogUtils.makeLogTag(UserInfo.class);

    public static final String JSON_AVATAR_UPDATED_AT = "avatar_updated_at";
    public static final String JSON_UID = "uid";
    public static final String JSON_LAST_VISITED_AT = "last_visited_at";
    public static final String JSON_CREATED_AT = "created_at";
    public static final String JSON_STATE = "state";
    public static final String JSON_LAST_DEVICE = "last_device";
    public static final String JSON_ROLE = "role";
    public static final String JSON_LOGIN = "login";
    public static final String JSON_ID = "id";
    public static final String JSON_ICON = "icon";


    private String mProfilePath;
    private String mName;

    private ArrayList<QiushiText> mQiushis;
    private Gender mGender;

    private int mAge;
    private int mQiuAge;

    private String mJob;
    private String mHomeTown;
    private String mLocation;

    public UserInfo(){
        mProfilePath = null;
        mName = "Pugna";
        mQiushis = new ArrayList<>();
        mGender = Gender.MALE;
        mAge = 25;
        mQiuAge = 4;
        mJob = "IT汪";
        mHomeTown = "福建·三明";
        mLocation = "上海";
    }

    public UserInfo(JSONObject json) throws JSONException{

    }

    public String getProfilePath() {
        return mProfilePath;
    }

    public void setProfilePath(String profilePath) {
        mProfilePath = profilePath;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public ArrayList<QiushiText> getQiushis() {
        return mQiushis;
    }

    public void setQiushis(ArrayList<QiushiText> qiushis) {
        mQiushis = qiushis;
    }

    public Gender getGender() {
        return mGender;
    }

    public void setGender(Gender gender) {
        mGender = gender;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }

    public int getQiuAge() {
        return mQiuAge;
    }

    public void setQiuAge(int qiuAge) {
        mQiuAge = qiuAge;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    public String getHomeTown() {
        return mHomeTown;
    }

    public void setHomeTown(String homeTown) {
        mHomeTown = homeTown;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    @Override
    public JSONObject toJSON() throws JSONException{
        return new JSONObject();
    }
}
