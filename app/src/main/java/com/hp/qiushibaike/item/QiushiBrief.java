package com.hp.qiushibaike.item;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.info.QiushiText;
import com.hp.qiushibaike.info.UserInfo;
import com.hp.qiushibaike.utils.LogUtils;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiBrief {
    private static final String TAG = LogUtils.makeLogTag(QiushiBrief.class);

    private static final int DEFAULT_USER_PROFILE_MALE = R.drawable.default_profile_male;
    private static final int DEFAULT_USER_PROFILE_FEMALE = R.drawable.default_profile_female;

    private QiushiText mQiushiText;

    public QiushiBrief(){
        mQiushiText = new QiushiText();
    }

    public QiushiBrief(QiushiText qiushiText){
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
