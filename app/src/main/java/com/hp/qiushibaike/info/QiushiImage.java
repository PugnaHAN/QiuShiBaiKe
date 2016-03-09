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

    public QiushiImage(){
        super();
    }

    public QiushiImage(JSONObject json) throws JSONException{
        super(json);
        mImageSizes = new ArrayList<>();
        JSONObject jsonObject = json.getJSONObject(JSON_IMAGE_SIZE);
        mImageSizes.add(new ImageSize(jsonObject.getJSONArray(JSON_S)));
        mImageSizes.add(new ImageSize(jsonObject.getJSONArray(JSON_M)));
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
