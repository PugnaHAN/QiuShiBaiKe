package com.hp.qiushibaike.info;

import com.hp.qiushibaike.utils.LogUtils;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiDetailInfo {
    private static final String TAG = LogUtils.makeLogTag(QiushiDetailInfo.class);

    public static final int MAX_CONTENT_LENGTH = 256;

    private static final int ONE_MINUTE = 60 * 1000;
    private static final int ONE_HOUR = 60 * ONE_MINUTE;

    // 糗事ID
    private long mId;
    // 作者信息
    private UserInfo mAuthor;
    // 糗事状态
    private QiushiStatus mStatus;
    // 发表时间
    private long mPublishedTime;
    // 通过时间
    private long mPassTime;
    // 糗事内容
    private String mQiushiContent;
    // 糗事赞数
    private int mQiushiGood;
    // 糗事踩数
    private int mQiushiBad;
    // 评论列表
    private ArrayList<Comment> mComments;

    public QiushiDetailInfo(){
        mId = 100001;
        mStatus = QiushiStatus.UNKNOWN;
        mPublishedTime = System.currentTimeMillis();
        mPassTime = System.currentTimeMillis();
        mQiushiGood = 2200;
        mQiushiBad = 0;
        mQiushiContent = "测试糗事";
        mComments = new ArrayList<>();
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public UserInfo getAuthor() {
        return mAuthor;
    }

    public void setAuthor(UserInfo author) {
        mAuthor = author;
    }

    public QiushiStatus getStatus() {
        return mStatus;
    }

    public void setStatus(QiushiStatus status) {
        mStatus = status;
    }

    public long getPublishedTime() {
        return mPublishedTime;
    }

    public void setPublishedTime(int publishedTime) {
        mPublishedTime = publishedTime;
    }

    public long getPassTime() {
        return mPassTime;
    }

    public void setPassTime(int passTime) {
        mPassTime = passTime;
    }

    public String getQiushiContent() {
        return mQiushiContent;
    }

    public void setQiushiContent(String qiushiContent) {
        mQiushiContent = qiushiContent;
    }

    public String getQiushiCoententBrief(){
        if(mQiushiContent.length() > MAX_CONTENT_LENGTH){
            return mQiushiContent.substring(0, MAX_CONTENT_LENGTH -1);
        } else {
            return mQiushiContent;
        }
    }

    public ArrayList<Comment> getComments() {
        return mComments;
    }

    public void setComments(ArrayList<Comment> comments) {
        mComments = comments;
    }

    public int getQiushiGood() {
        return mQiushiGood;
    }

    public void setQiushiGood(int qiushiGood) {
        mQiushiGood = qiushiGood;
    }

    public int getQiushiBad() {
        return mQiushiBad;
    }

    public void setQiushiBad(int qiushiBad) {
        mQiushiBad = qiushiBad;
    }

    public int getQiushiZan(){
        return mQiushiGood - mQiushiBad;
    }

    public enum PopularStatus{
        NONE,
        HOT,
        FRESH
    }
    public PopularStatus getPopularStatus(){
        if(this.getStatus() == QiushiStatus.PASS){
            long currentTime = System.currentTimeMillis();
            if(currentTime - mPassTime < ONE_HOUR){
                return PopularStatus.FRESH;
            } else if(getQiushiZan() > 2000){
                return PopularStatus.HOT;
            } else {
                return PopularStatus.NONE;
            }
        }
        return PopularStatus.NONE;
    }
}
