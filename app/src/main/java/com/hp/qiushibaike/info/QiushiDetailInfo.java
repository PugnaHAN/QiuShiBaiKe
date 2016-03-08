package com.hp.qiushibaike.info;

import com.hp.qiushibaike.utils.IdUtils;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiDetailInfo {
    private static final String TAG = LogUtils.makeLogTag(QiushiDetailInfo.class);

    public static final int MAX_CONTENT_LENGTH = 256;

    private static final int ONE_MINUTE = 60 * 1000;
    private static final int ONE_HOUR = 60 * ONE_MINUTE;

    public static final String JSON_FORMAT = "format";
    public static final String JSON_IMAGE_FILE = "image";
    public static final String JSON_PUBLISHED_TIME = "published_at";
    public static final String JSON_TAGS = "tag";
    public static final String JSON_AUTHOR = "user";
    public static final String JSON_IMAGE_SIZE = "image_size";
    public static final String JSON_ID = "id";
    public static final String JSON_VOTE = "votes";
    public static final String JSON_CREATE_TIME = "created_at";
    public static final String JSON_CONTENT = "content";
    public static final String JSON_STATE = "state";
    public static final String JSON_COMMENT_COUNT = "comments_count";
    public static final String JSON_ALLOW_COMMENT = "allow_comment";
    public static final String JSON_SHARE_COUNT = "share_count";
    public static final String JSON_LOOP = "loop";

    // 糗事类型 - 图片，文字，视频等
    private Format mFormat;
    // 图片文件
    private String mImageFile;
    // 发表时间
    private long mPublishedTime;
    // 糗事标签
    private ArrayList<String> mTags;
    // 作者信息
    private UserInfo mAuthor;
    // 图像大小 - Json中包括S和M两种
    private ArrayList<ImageSize> mImageSizes;
    // 糗事ID
    private long mId;
    // 糗事状态
    private QiushiStatus mStatus;
    // 糗事总结
    private Vote mVote;
    // 通过时间
    private long mCreateTime;
    // 糗事内容
    private String mQiushiContent;
    // 评论数目
    private int mCommentCount;
    // 是否可评
    private boolean mIsAllowComment;
    // 共享数目
    private int mShareCount;
    // 糗事热度
    private QiushiType mQiushiType;
    // 审阅次数
    private int mLoop;

    public QiushiDetailInfo(){
        mFormat = Format.WORLD;
        mImageFile = null;
        mPublishedTime = System.currentTimeMillis();
        mTags = new ArrayList<>();
        mAuthor = new UserInfo();
        mImageSizes = new ArrayList<>();
        mId = IdUtils.generateId();
        mStatus = QiushiStatus.PUBLISH;
        mCreateTime = System.currentTimeMillis();
        mVote = new Vote(3000, 455);
        mQiushiContent = "测试糗事";
        mCommentCount = 0;
        mIsAllowComment = true;
        mShareCount = 0;
        mQiushiType = QiushiType.HOT;
    }

    public Format getFormat() {
        return mFormat;
    }

    public void setFormat(Format format) {
        mFormat = format;
    }

    public String getImageFile() {
        return mImageFile;
    }

    public void setImageFile(String imageFile) {
        if(mFormat == Format.IMAGE) {
            mImageFile = imageFile;
        } else {
            mImageFile = null;
        }
    }

    public long getPublishedTime() {
        return mPublishedTime;
    }

    public void setPublishedTime(long publishedTime) {
        mPublishedTime = publishedTime;
    }

    public ArrayList<String> getTags() {
        return mTags;
    }

    public void setTags(ArrayList<String> tags) {
        mTags = tags;
    }

    public UserInfo getAuthor() {
        return mAuthor;
    }

    public void setAuthor(UserInfo author) {
        mAuthor = author;
    }

    public ArrayList<ImageSize> getImageSizes() {
        return mImageSizes;
    }

    public void setImageSizes(ArrayList<ImageSize> imageSizes) {
        mImageSizes = imageSizes;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        if(IdUtils.isUnique(id)) {
            mId = id;
        } else {
            mId = IdUtils.generateId();
        }
    }

    public QiushiStatus getStatus() {
        return mStatus;
    }

    public void setStatus(QiushiStatus status) {
        mStatus = status;
    }

    public long getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(long createTime) {
        mCreateTime = createTime;
    }

    public Vote getVote() {
        return mVote;
    }

    public void setVote(Vote vote) {
        mVote = vote;
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

    public int getCommentCount() {
        return mCommentCount;
    }

    public void setCommentCount(int commentCount) {
        mCommentCount = commentCount;
    }

    public boolean isAllowComment() {
        return mIsAllowComment;
    }

    public void setIsAllowComment(boolean isAllowComment) {
        mIsAllowComment = isAllowComment;
    }

    public int getShareCount() {
        return mShareCount;
    }

    public void setShareCount(int shareCount) {
        mShareCount = shareCount;
    }

    public QiushiType getQiushiType() {
        return mQiushiType;
    }

    public void setQiushiType(QiushiType qiushiType) {
        mQiushiType = qiushiType;
    }

    public int getQiushiZan(){
        return mVote.up - mVote.down;
    }

    public int getLoop() {
        return mLoop;
    }

    public void setLoop(int loop) {
        mLoop = loop;
    }

    public enum Format{
        WORLD,
        IMAGE,
        VIDEO,
        UKNOWN
    }

    public String formatToString(Format format){
        String formatStr;
        switch (format){
            case WORLD:
                formatStr = "world";
                break;
            case IMAGE:
                formatStr = "image";
                break;
            case VIDEO:
                formatStr = "vedio";
                break;
            default:
                formatStr = "unkown";
                break;
        }
        return formatStr;
    }

    public String formatToString(QiushiStatus status){
        String formatStr;
        switch (status){
            case :
                formatStr = "publish";

        }
    }

    private class ImageSize{
        public int width = 0;
        public int height = 0;
        public int size = 0;

        public ImageSize(){
            width = 0;
            height = 0;
            size = 0;
        }

        public ImageSize(int w, int h, int s){
            width = w;
            height = h;
            size = s;
        }
    }

    private class Vote{
        private final String JSON_DOWN = "down";
        private final String JSON_UP = "up";

        public int up;
        public int down;

        public Vote(){
            up = 0;
            down = 0;
        }

        public Vote(int u, int d){
            up = u;
            down = d;
        }

        public JSONObject toJSON() throws JSONException{
            JSONObject json = new JSONObject();
            json.put(JSON_DOWN, down);
            json.put(JSON_UP, up);
            return json;
        }
    }

    public enum QiushiType{
        HOT,
        PROMOTE,
        FRESH
    }

    private JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        json.put(JSON_FORMAT, formatToString(mFormat));
        json.put(JSON_IMAGE_FILE, mImageFile);
        json.put(JSON_PUBLISHED_TIME, mPublishedTime);
        json.put(JSON_TAGS, getJSON(mTags));
        json.put(JSON_AUTHOR, mAuthor.toJSON());
        json.put(JSON_IMAGE_SIZE, getJSON(mImageSizes));
        json.put(JSON_ID, mId);
        json.put(JSON_VOTE, mVote.toJSON());
        json.put(JSON_CREATE_TIME, mCreateTime);
        json.put(JSON_CONTENT, mQiushiContent);
        json.put(JSON_STATE, mStatus);


        return json;
    }

    public static final String JSON_CREATE_TIME = "created_at";
    public static final String JSON_CONTENT = "content";
    public static final String JSON_STATE = "state";
    public static final String JSON_COMMENT_COUNT = "comments_count";
    public static final String JSON_ALLOW_COMMENT = "allow_comment";
    public static final String JSON_SHARE_COUNT = "share_count";
    public static final String JSON_LOOP = "loop";
}
