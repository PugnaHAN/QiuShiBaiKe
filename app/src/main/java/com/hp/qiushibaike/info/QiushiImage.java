package com.hp.qiushibaike.info;

import com.hp.qiushibaike.info.enums.Format;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/3/9.
 */
public class QiushiImage extends QiushiSimpleObject {
    private static final String TAG = LogUtils.makeLogTag(QiushiImage.class);

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(JSON_FORMAT, Format.IMAGE);
        json.put(JSON_IMAGE_FILE, null);
        json.put(JSON_PUBLISHED_AT, mPublishedTime);
        json.put(JSON_TAGS, new JSONArray(mTags.toArray()));
        json.put(JSON_AUTHOR, mAuthor.toJSON());
        json.put(JSON_IMAGE_SIZE, getJSON(mImageSizes));
        json.put(JSON_ID, mId);
        json.put(JSON_VOTE, mVote.toJSON());
        json.put(JSON_CREATE_AT, mCreateTime);
        json.put(JSON_CONTENT, mQiushiContent);
        json.put(JSON_STATE, mState);
        json.put(JSON_COMMENT_COUNT, mCommentCount);
        json.put(JSON_ALLOW_COMMENT, mIsAllowComment);
        json.put(JSON_SHARE_COUNT, mShareCount);
        return json;
    }

    @Override
    protected JSONObject getJSON(ArrayList<ImageSize> imageSizes) throws JSONException{
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonArray.put(imageSizes.get(0).width);
        jsonArray.put(imageSizes.get(0).height);
        jsonArray.put(imageSizes.get(0).size);
        json.put(JSON_S, jsonArray);

        jsonArray = new JSONArray();
        jsonArray.put(imageSizes.get(0).width);
        jsonArray.put(imageSizes.get(0).height);
        jsonArray.put(imageSizes.get(0).size);
        json.put(JSON_M, jsonArray);

        return json;
    }
}
