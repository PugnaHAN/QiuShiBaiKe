package com.hp.qiushibaike.item;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.info.QiushiDetailInfo;
import com.hp.qiushibaike.info.UserInfo;
import com.hp.qiushibaike.utils.LogUtils;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiBrief {
    private static final String TAG = LogUtils.makeLogTag(QiushiBrief.class);

    private static final int DEFAULT_USER_PROFILE_MALE = R.drawable.default_profile_male;
    private static final int DEFAULT_USER_PROFILE_FEMALE = R.drawable.default_profile_female;

    private UserInfo mUserInfo;
    private QiushiDetailInfo mQiushiDetailInfo;

    public QiushiBrief(){
        mUserInfo = new UserInfo();
        mQiushiDetailInfo = new QiushiDetailInfo();
    }

    public QiushiBrief(UserInfo userInfo, QiushiDetailInfo qiushiDetailInfo){
        mUserInfo = userInfo;
        mQiushiDetailInfo = qiushiDetailInfo;
    }

    public UserInfo getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        mUserInfo = userInfo;
    }

    public QiushiDetailInfo getQiushiDetailInfo() {
        return mQiushiDetailInfo;
    }

    public void setQiushiDetailInfo(QiushiDetailInfo qiushiDetailInfo) {
        mQiushiDetailInfo = qiushiDetailInfo;
    }
}
