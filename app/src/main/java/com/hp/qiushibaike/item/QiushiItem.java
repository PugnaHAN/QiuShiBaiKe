package com.hp.qiushibaike.item;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.info.QiushiText;
import com.hp.qiushibaike.info.UserInfo;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiItem {
    private static final String TAG = LogUtils.makeLogTag(QiushiItem.class);

    private QiushiText mQiushiText;

    public QiushiItem(){
        mQiushiText = new QiushiText();
    }

    public QiushiItem(JSONObject json) throws JSONException{
        mQiushiText = new QiushiText(json);
    }

    public QiushiItem(QiushiText qiushiText){
        mQiushiText = qiushiText;
    }

    public UserInfo getUserInfo() {
        return getQiushiText().getAuthor();
    }

    public void setUserInfo(UserInfo userInfo) {
        getQiushiText().setAuthor(userInfo);
    }

    public QiushiText getQiushiText() {
        return mQiushiText;
    }

    public void setQiushiText(QiushiText qiushiText) {
        mQiushiText = qiushiText;
    }
}
