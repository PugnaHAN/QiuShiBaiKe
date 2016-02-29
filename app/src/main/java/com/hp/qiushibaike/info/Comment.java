package com.hp.qiushibaike.info;

import com.hp.qiushibaike.utils.LogUtils;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class Comment {
    private static final String TAG = LogUtils.makeLogTag(Comment.class);

    // 评论作者
    private UserInfo mAuthor;
    // 评论状态
    public enum CommentStatus {
        UNKNOWN,
        OK,
        REPORTED
    }
    private CommentStatus mStatus;
    private String mContent;
    private int mFloor;

    public UserInfo getAuthor() {
        return mAuthor;
    }

    public void setAuthor(UserInfo author) {
        mAuthor = author;
    }

    public CommentStatus getStatus() {
        return mStatus;
    }

    public void setStatus(CommentStatus status) {
        mStatus = status;
    }

    public String getContent() {
        return mContent;
    }

    public void setContent(String content) {
        mContent = content;
    }

    public int getFloor() {
        return mFloor;
    }

    public void setFloor(int floor) {
        mFloor = floor;
    }
}
