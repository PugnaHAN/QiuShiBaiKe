package com.hp.qiushibaike.info;

import com.hp.qiushibaike.info.enums.State;
import com.hp.qiushibaike.utils.IdUtils;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class UserInfo extends UserBasicObject {
    private static final String TAG = LogUtils.makeLogTag(UserInfo.class);

    public static final String JSON_AVATAR_UPDATED_AT = "avatar_updated_at";
    public static final String JSON_LAST_VISITED_AT = "last_visited_at";
    public static final String JSON_STATE = "state";
    public static final String JSON_LAST_DEVICE = "last_device";
    public static final String JSON_ROLE = "role";
    public static final String JSON_ID = "id";

    private long mAvatarUpdatedAt;
    private long mLastVisitedAt;
    private State mState;
    private String mLastDevice;
    private String mRole;
    private long mId;

    public UserInfo(){
        mAvatarUpdatedAt = System.currentTimeMillis();
        mLastVisitedAt = System.currentTimeMillis();
        mState = State.BONDED;
        mLastDevice = "ios_9.1.6";
        mRole = "n";
        mId = IdUtils.generateId();
    }
    public UserInfo(JSONObject json) throws JSONException{
        super(json);
        mAvatarUpdatedAt = json.getLong(JSON_AVATAR_UPDATED_AT);
        mLastVisitedAt = json.getLong(JSON_LAST_VISITED_AT);
        mState = State.decodeString(json.getString(JSON_STATE));
        mLastDevice = json.getString(JSON_LAST_DEVICE);
        if(json.has(JSON_ROLE)){
            mRole = json.getString(JSON_ROLE);
        } else {
            mRole = null;
        }
        mId = json.getLong(JSON_ID);
    }
    @Override
    public JSONObject toJSON() throws JSONException{
        JSONObject json = super.toJSON();
        json.put(JSON_AVATAR_UPDATED_AT, mAvatarUpdatedAt);
        json.put(JSON_LAST_VISITED_AT, mLastVisitedAt);
        json.put(JSON_STATE, mState);
        json.put(JSON_LAST_DEVICE, mLastDevice);
        if(mRole != null) {
            json.put(JSON_ROLE, mRole);
        }
        json.put(JSON_ID, mId);
        return new JSONObject();
    }

    public long getAvatarUpdatedAt() {
        return mAvatarUpdatedAt;
    }

    public void setAvatarUpdatedAt(long avatarUpdatedAt) {
        mAvatarUpdatedAt = avatarUpdatedAt;
    }

    public long getLastVisitedAt() {
        return mLastVisitedAt;
    }

    public void setLastVisitedAt(long lastVisitedAt) {
        mLastVisitedAt = lastVisitedAt;
    }

    public State getState() {
        return mState;
    }

    public void setState(State state) {
        mState = state;
    }

    public String getLastDevice() {
        return mLastDevice;
    }

    public void setLastDevice(String lastDevice) {
        mLastDevice = lastDevice;
    }

    public String getRole() {
        return mRole;
    }

    public void setRole(String role) {
        mRole = role;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }
}
