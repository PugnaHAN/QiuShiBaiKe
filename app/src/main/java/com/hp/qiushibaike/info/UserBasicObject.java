package com.hp.qiushibaike.info;

import com.hp.qiushibaike.utils.IdUtils;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangjuh on 2016/3/8.
 */
public class UserBasicObject {
    private static final String TAG = LogUtils.makeLogTag(UserBasicObject.class);

    public static final String JSON_UID = "uid";
    public static final String JSON_ICON = "icon";
    public static final String JSON_CREATED_AT = "created_at";
    public static final String JSON_LOGIN = "login";

    protected long mUid;
    protected String mIcon;
    protected long mCreateTime;
    protected String mLogin;

    public UserBasicObject(){
        mUid = IdUtils.generateId();
        mIcon = null;
        mCreateTime = System.currentTimeMillis();
        mLogin = "Test";
    }

    public UserBasicObject(long uid, String icon, long createTime, String login){
        mUid = uid;
        mIcon = icon;
        mCreateTime = createTime;
        mLogin = login;
    }

    public JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        json.put(JSON_UID, mUid);
        json.put(JSON_ICON, mIcon);
        json.put(JSON_CREATED_AT, mCreateTime);
        json.put(JSON_LOGIN, mLogin);
        return json;
    }
}
