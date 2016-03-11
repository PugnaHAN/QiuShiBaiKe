package com.hp.qiushibaike.info;

import com.hp.qiushibaike.Constants;
import com.hp.qiushibaike.utils.IdUtils;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

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
        mLogin = "匿名用户";
    }

    public UserBasicObject(long uid, String icon, long createTime, String login){
        mUid = uid;
        mIcon = icon;
        mCreateTime = createTime;
        mLogin = login;
    }

    public UserBasicObject(JSONObject json) throws JSONException{
        mUid = json.getLong(JSON_UID);
        mIcon = json.getString(JSON_ICON);
        mCreateTime = json.getLong(JSON_CREATED_AT);
        mLogin = json.getString(JSON_LOGIN);
    }

    public JSONObject toJSON() throws JSONException{
        JSONObject json = new JSONObject();
        json.put(JSON_UID, mUid);
        json.put(JSON_ICON, mIcon);
        json.put(JSON_CREATED_AT, mCreateTime);
        json.put(JSON_LOGIN, mLogin);
        return json;
    }

    public long getUid() {
        return mUid;
    }

    public void setUid(long uid) {
        mUid = uid;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public long getCreateTime() {
        return mCreateTime;
    }

    public void setCreateTime(long createTime) {
        mCreateTime = createTime;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String login) {
        mLogin = login;
    }

    public String getIconDetailUrl(){
        String imageUrl;
        if(mIcon != null) {
            imageUrl =  String.format(Constants.ARATAR_URL, String.valueOf(mUid / 10000),
                    "medium", mIcon);
        } else {
            imageUrl =  null;
        }
        LogUtils.LOGD(TAG, "icon url: " + imageUrl);
        return imageUrl;
    }
}
