package com.hp.qiushibaike.info;

import com.hp.qiushibaike.utils.LogUtils;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class UserInfo {
    private static final String TAG = LogUtils.makeLogTag(UserInfo.class);

    private String mProfilePath;
    private String mName;

    private ArrayList<QiushiDetailInfo> mQiushis;

    public enum Gender{
        MALE,
        FEMALE,
        UNKNOWN
    }
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

    public ArrayList<QiushiDetailInfo> getQiushis() {
        return mQiushis;
    }

    public void setQiushis(ArrayList<QiushiDetailInfo> qiushis) {
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
}
