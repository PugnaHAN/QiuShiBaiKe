package com.hp.qiushibaike.holder;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.info.QiushiText;
import com.hp.qiushibaike.info.UserInfo;
import com.hp.qiushibaike.utils.LogUtils;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiHolder extends RecyclerView.ViewHolder {
    private static final String TAG = LogUtils.makeLogTag(QiushiHolder.class);

    private ImageView mUserProfile;
    private TextView mUserName;
    private ImageView mPopularRate;
    private TextView mPopularDesc;

    private TextView mQiushiContent;

    private TextView mQiushiSummary;
    private ImageView mQiushiGood;
    private ImageView mQiushiBad;
    private ImageView mQiushiComment;
    private ImageView mQiushiMore;

    public QiushiHolder(View v){
        super(v);
        mUserName = (TextView) v.findViewById(R.id.qiushi_people_name);
        mUserProfile = (ImageView) v.findViewById(R.id.qiushi_profile);

        mPopularRate = (ImageView) v.findViewById(R.id.qiushi_popular);
        mPopularDesc = (TextView) v.findViewById(R.id.qiushi_popular_desc);

        mQiushiContent = (TextView) v.findViewById(R.id.qiushi_brief);


        mQiushiSummary = (TextView) v.findViewById(R.id.qiushi_summary);
        // TODO: How to handle the pressing buttons
        mQiushiGood = (ImageView) v.findViewById(R.id.qiushi_good);
        mQiushiBad = (ImageView) v.findViewById(R.id.qiushi_bad);
        mQiushiComment = (ImageView) v.findViewById(R.id.qiushi_comment);
        mQiushiMore = (ImageView) v.findViewById(R.id.qiushi_more);
    }

    public void setUserProfile(int resourceId){
        mUserProfile.setImageResource(resourceId);
    }

    public void setUserProfile(String path, UserInfo.Gender gender){
        if(path != null) {
            Uri uri = Uri.parse(path);
            mUserProfile.setImageURI(uri);
        } else {
            setUserProfile(gender == UserInfo.Gender.MALE?
                    R.drawable.default_profile_male:
                    R.drawable.default_profile_female);
        }
    }

    public void setUserName(String userName){
        mUserName.setText(userName);
    }

    public void setPopularRate(QiushiText.QiushiType type){
        switch (type){
            case HOT:
                mPopularRate.setImageResource(R.drawable.ic_rss_hot);
                break;
            case FRESH:
                mPopularRate.setImageResource(R.drawable.ic_rss_fresh);
                break;
            case PROMOTE:
                mPopularRate.setVisibility(View.GONE);
                break;
        }
    }

    public void setPopularDesc(QiushiText.QiushiType status){
        switch (status){
            case HOT:
                mPopularDesc.setText("热门");
                break;
            case FRESH:
                mPopularDesc.setText("新鲜");
                break;
            case PROMOTE:
                mPopularDesc.setVisibility(View.GONE);
                break;
        }
    }

    public void setQiushiContent(String content){
        mQiushiContent.setText(content);
    }

    public void setQiushiSummary(int goodNo, int commentNo){
        String summary = "好笑 " + goodNo + "·评论 " + commentNo;
        mQiushiSummary.setText(summary);
    }
}
