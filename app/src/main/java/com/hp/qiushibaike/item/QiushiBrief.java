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

    private QiushiDetailInfo mQiushiDetailInfo;

    public QiushiBrief(){
        mQiushiDetailInfo = new QiushiDetailInfo();
    }

    public QiushiBrief(QiushiDetailInfo qiushiDetailInfo){
        mQiushiDetailInfo = qiushiDetailInfo;
    }

    public UserInfo getUserInfo() {
        return getQiushiDetailInfo().getAuthor();
    }

    public void setUserInfo(UserInfo userInfo) {
        getQiushiDetailInfo().setAuthor(userInfo);
    }

    public QiushiDetailInfo getQiushiDetailInfo() {
        return mQiushiDetailInfo;
    }

    public void setQiushiDetailInfo(QiushiDetailInfo qiushiDetailInfo) {
        mQiushiDetailInfo = qiushiDetailInfo;
    }
}
