package com.hp.qiushibaike.info;

import com.hp.qiushibaike.info.enums.AstroLogy;
import com.hp.qiushibaike.info.enums.Emotion;
import com.hp.qiushibaike.info.enums.Gender;
import com.hp.qiushibaike.info.enums.RelationShip;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.GenericDeclaration;

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
    public static final String JSON_INTRODUCE = "introduce";
    public static final String JSON_JOB = "job";
    public static final String JSON_GENDER = "gender";
    public static final String JSON_SIGNATURE = "signature";
    public static final String JSON_AGE = "age";

    private Emotion mEmotion;
    private String mHomeTown;
    private String mHaunt;
    private int mQbAge;
    private AstroLogy mAstroLogy;
    private String mMobileBrand;
    private int mSmileCount;
    private String mBigCover;
    private int mQiuShiCnt;
    private String mLocation;
    private String mHobby;
    private String mBg;
    private RelationShip mRelationShip;
    private String mIntroduce;
    private String mJob;
    private Gender mGender;
    private String mSignature;
    private int mAge;

    public UserDetail(){
        mEmotion = Emotion.NONE;
        mHomeTown = "福建 · 三明";
        mHaunt = "";
        mQbAge = 3;
        mAstroLogy = AstroLogy.CAPRICORN;
        mSmileCount = 8000;
        mBigCover = "";
        mQiuShiCnt = 4;
        mLocation = "上海浦东";
        mHobby = "";
        mBg = "";
        mRelationShip = RelationShip.NO_RELATIONSHIP;
        mIntroduce = "";
        mGender = Gender.MALE;
        mSignature = "";
        mAge = 25;
    }

    public UserDetail(JSONObject json) throws JSONException{
        mEmotion = mEmotion.getByCode(json.getString(JSON_EMOTION));
        mHomeTown = json.getString(JSON_HOMETOWN);
        mHaunt = json.getString(JSON_HAUNT);
        mQbAge = json.getInt(JSON_QB_AGE);
        mAstroLogy = mAstroLogy.getByCode(json.getString(JSON_ASTROLOGY));
        mMobileBrand = json.getString(JSON_MOBILE_BRAND);
        mSmileCount = json.getInt(JSON_SMILE_COUNT);
        mBigCover = json.getString(JSON_BIG_COVER);
        mQiuShiCnt = json.getInt(JSON_QS_COUNT);
        mLocation = json.getString(JSON_LOCATION);
        mHobby = json.getString(JSON_HOBBY);
        mBg = json.getString(JSON_BG);
        mRelationShip = mRelationShip.getByCode(json.getString(JSON_RELATIONSHIP));
        mIntroduce = json.getString(JSON_INTRODUCE);
        mJob = json.getString(JSON_JOB);
        mGender = mGender.getByCode(json.getString(JSON_GENDER));
        mSignature = json.getString(JSON_SIGNATURE);
        mAge = json.getInt(JSON_AGE);
    }

    @Override
    public JSONObject toJSON() throws JSONException{
        JSONObject json = super.toJSON();
        json.put(JSON_EMOTION, mEmotion);
        json.put(JSON_HOMETOWN, mHomeTown);
        json.put(JSON_HAUNT, mHaunt);
        json.put(JSON_QB_AGE, mQbAge);
        json.put(JSON_ASTROLOGY, mAstroLogy);
        json.put(JSON_MOBILE_BRAND, mMobileBrand);
        json.put(JSON_SMILE_COUNT, mSmileCount);
        json.put(JSON_BIG_COVER, mBigCover);
        json.put(JSON_QS_COUNT, mQiuShiCnt);
        json.put(JSON_LOCATION, mLocation);
        json.put(JSON_HOBBY, mHobby);
        json.put(JSON_BG, mBg);
        json.put(JSON_RELATIONSHIP, mRelationShip);
        json.put(JSON_INTRODUCE, mIntroduce);
        json.put(JSON_JOB, mJob);
        json.put(JSON_GENDER, mGender);
        json.put(JSON_SIGNATURE, mSignature);
        json.put(JSON_AGE, mAge);
        return json;
    }

    public Emotion getEmotion() {
        return mEmotion;
    }

    public void setEmotion(Emotion emotion) {
        mEmotion = emotion;
    }

    public String getHomeTown() {
        return mHomeTown;
    }

    public void setHomeTown(String homeTown) {
        mHomeTown = homeTown;
    }

    public String getHaunt() {
        return mHaunt;
    }

    public void setHaunt(String haunt) {
        mHaunt = haunt;
    }

    public int getQbAge() {
        return mQbAge;
    }

    public void setQbAge(int qbAge) {
        mQbAge = qbAge;
    }

    public AstroLogy getAstroLogy() {
        return mAstroLogy;
    }

    public void setAstroLogy(AstroLogy astroLogy) {
        mAstroLogy = astroLogy;
    }

    public String getMobileBrand() {
        return mMobileBrand;
    }

    public void setMobileBrand(String mobileBrand) {
        mMobileBrand = mobileBrand;
    }

    public int getSmileCount() {
        return mSmileCount;
    }

    public void setSmileCount(int smileCount) {
        mSmileCount = smileCount;
    }

    public String getBigCover() {
        return mBigCover;
    }

    public void setBigCover(String bigCover) {
        mBigCover = bigCover;
    }

    public int getQiuShiCnt() {
        return mQiuShiCnt;
    }

    public void setQiuShiCnt(int qiuShiCnt) {
        mQiuShiCnt = qiuShiCnt;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getHobby() {
        return mHobby;
    }

    public void setHobby(String hobby) {
        mHobby = hobby;
    }

    public String getBg() {
        return mBg;
    }

    public void setBg(String bg) {
        mBg = bg;
    }

    public RelationShip getRelationShip() {
        return mRelationShip;
    }

    public void setRelationShip(RelationShip relationShip) {
        mRelationShip = relationShip;
    }

    public String getIntroduce() {
        return mIntroduce;
    }

    public void setIntroduce(String introduce) {
        mIntroduce = introduce;
    }

    public String getJob() {
        return mJob;
    }

    public void setJob(String job) {
        mJob = job;
    }

    public Gender getGender() {
        return mGender;
    }

    public void setGender(Gender gender) {
        mGender = gender;
    }

    public String getSignature() {
        return mSignature;
    }

    public void setSignature(String signature) {
        mSignature = signature;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int age) {
        mAge = age;
    }
}
