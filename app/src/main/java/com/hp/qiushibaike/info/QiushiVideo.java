package com.hp.qiushibaike.info;

import com.hp.qiushibaike.info.enums.Format;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.ProcessingInstruction;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/3/9.
 */
public class QiushiVideo extends QiushiSimpleObject {
    private static final String TAG = LogUtils.makeLogTag(QiushiVideo.class);

    private static final String JSON_HIGH_URL= "high_url";
    private static final String JSON_LOW_URL = "low_url";
    private static final String JSON_PIC_URL = "pic_url";
    private static final String JSON_PIC_SIZE = "pic_size";
    private static final String JSON_LOOP = "loop";

    private String mHighUrl;
    private String mLowUrl;
    private String mPicUrl;
    private PicSize mPicSize;
    private int mLoop;

    public QiushiVideo(){
        super();
        mHighUrl = null;
        mLowUrl = null;
        mPicUrl = null;
        mPicSize = null;
        mLoop = 0;
    }

    public QiushiVideo(JSONObject json) throws JSONException{
        super(json);
        mImageSizes = null;
        mHighUrl = json.getString(JSON_HIGH_URL);
        mLowUrl = json.getString(JSON_LOW_URL);
        mPicUrl = json.getString(JSON_PIC_URL);
        mPicSize = new PicSize(json.getJSONArray(JSON_PIC_SIZE));
        mLoop = json.getInt(JSON_LOOP);
    }

    @Override
    public JSONObject toJSON() throws JSONException {
        JSONObject json = super.toJSON();
        json.put(JSON_IMAGE_SIZE, null);
        json.put(JSON_HIGH_URL, mHighUrl);
        json.put(JSON_PIC_SIZE, mPicSize.toJSON());
        json.put(JSON_PIC_URL, mPicUrl);
        json.put(JSON_LOW_URL, mLowUrl);
        json.put(JSON_LOOP, mLoop);
        return json;
    }

    @Override
    protected JSONObject getJSON(ArrayList<ImageSize> imageSizes) throws JSONException{
        return null;
    }

    private class PicSize{
        public int width;
        public int height;

        public PicSize(){
            width = 0;
            height = 0;
        }

        public PicSize(int w, int h){
            width = w;
            height = h;
        }

        public PicSize(JSONArray jsonArray) throws JSONException{
            width = jsonArray.getInt(0);
            height = jsonArray.getInt(1);
        }

        public JSONArray toJSON() throws JSONException{
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(width);
            jsonArray.put(height);
            return jsonArray;
        }
    }
}
