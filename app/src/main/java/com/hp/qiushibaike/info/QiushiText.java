package com.hp.qiushibaike.info;

import com.hp.qiushibaike.info.enums.Format;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiText extends QiushiSimpleObject{
    private static final String TAG = LogUtils.makeLogTag(QiushiText.class);

    public QiushiText(){
        super();
    }

    public QiushiText(JSONObject json) throws JSONException{
        super(json);
        mImageSizes = null;
    }

    @Override
    protected JSONObject getJSON(ArrayList<ImageSize> imageSizes) throws JSONException{
        return null;
    }
}
