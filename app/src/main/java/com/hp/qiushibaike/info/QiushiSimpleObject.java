package com.hp.qiushibaike.info;

import com.hp.qiushibaike.info.enums.Format;
import com.hp.qiushibaike.info.enums.Status;
import com.hp.qiushibaike.info.enums.Type;
import com.hp.qiushibaike.utils.IdUtils;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public abstract class QiushiSimpleObject {
    private static final String TAG = LogUtils.makeLogTag(QiushiSimpleObject.class);

    public static final int MAX_CONTENT_LENGTH = 256;

    protected static final int ONE_MINUTE = 60 * 1000;
    protected static final int ONE_HOUR = 60 * ONE_MINUTE;

    protected static final String JSON_FORMAT = "format";
    protected static final String JSON_IMAGE_FILE = "image";
    protected static final String JSON_PUBLISHED_AT = "published_at";
    protected static final String JSON_TAGS = "tag";
    protected static final String JSON_AUTHOR = "user";
    protected static final String JSON_IMAGE_SIZE = "image_size";
    protected static final String JSON_ID = "id";
    protected static final String JSON_VOTE = "votes";
    protected static final String JSON_CREATE_AT = "created_at";
    protected static final String JSON_CONTENT = "content";
    protected static final String JSON_STATE = "state";
    protected static final String JSON_COMMENT_COUNT = "comments_count";
    protected static final String JSON_ALLOW_COMMENT = "allow_comment";
    protected static final String JSON_SHARE_COUNT = "share_count";

    public static final int S = 0;
    public static final int M = 1;

    // 糗事类型 - 图片，文字，视频等
    protected Format mFormat;
    // 图片文件
    protected String mImageFile;
    // 发表时间
    protected long mPublishedTime;
    // 糗事标签
    protected ArrayList<String> mTags;
    // 作者信息
    protected UserInfo mAuthor;
    // 图像大小 - Json中包括S和M两种
    protected ArrayList<ImageSize> mImageSizes;
    // 糗事ID
    protected long mId;
    // 糗事状态
    protected Status mStatus;
    // 糗事总结
    protected Vote mVote;
    // 通过时间
    protected long mCreateTime;
    // 糗事内容
    protected String mQiushiContent;
    // 评论数目
    protected int mCommentCount;
    // 是否可评
    protected boolean mIsAllowComment;
    // 共享数目
    protected int mShareCount;
    // 糗事热度
    protected Type mQiushiType;

    public QiushiSimpleObject(){
        mFormat = Format.WORD;
        mImageFile = null;
        mPublishedTime = System.currentTimeMillis();
        mTags = new ArrayList<>();
        mAuthor = new UserInfo();
        mImageSizes = new ArrayList<>();
        mId = IdUtils.generateId();
        mStatus = Status.PUBLISH;
        mCreateTime = System.currentTimeMillis();
        mVote = new Vote(3000, 455);
        mQiushiContent = "测试糗事";
        mCommentCount = 0;
        mIsAllowComment = true;
        mShareCount = 0;
        mQiushiType = Type.HOT;
    }

    public QiushiSimpleObject(JSONObject json) throws JSONException{

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

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
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

    public Type getQiushiType() {
        return mQiushiType;
    }

    public void setQiushiType(Type qiushiType) {
        mQiushiType = qiushiType;
    }

    public int getQiushiZan(){
        return mVote.up - mVote.down;
    }

    protected class ImageSize{
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

        public JSONArray toJSON() throws JSONException{
            JSONArray json = new JSONArray();
            json.put(width);
            json.put(height);
            json.put(size);
            return json;
        }
    }

    protected class Vote{
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

    public abstract JSONObject toJSON() throws JSONException;

    protected abstract JSONObject getJSON(ArrayList<ImageSize> imageSizes);
}

