package com.hp.qiushibaike.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.holder.QiushiHolder;
import com.hp.qiushibaike.info.enums.Type;
import com.hp.qiushibaike.item.QiushiItem;
import com.hp.qiushibaike.utils.LogUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiAdapter extends RecyclerView.Adapter<QiushiHolder> {
    private static final String TAG = LogUtils.makeLogTag(QiushiAdapter.class);

    private Context mContext;

    private ArrayList<QiushiItem> mQiushiItemList;

    public QiushiAdapter(ArrayList<QiushiItem> qiushiItems, Context context){
        mQiushiItemList = qiushiItems;
        mContext = context;
    }

    @Override
    public int getItemCount(){
        int count =  mQiushiItemList.size();
        // Log.d(TAG, "size is " + count);
        return count;
    }

    @Override
    public void onBindViewHolder(QiushiHolder qiushiHolder, int i){
        QiushiItem qb = mQiushiItemList.get(i);
        // Random random = new Random();
        // qiushiHolder.setUserProfile(random.nextInt(10) % 2 == 1 ? R.drawable.default_profile_male :
        //          R.drawable.default_profile_female);
        if(qb.getUserInfo() == null){
            qiushiHolder.setUserProfile(R.drawable.default_anonymous_users_avatar);
        } else {
            if(qb.getUserInfo().getIconDetailUrl() == null){
                qiushiHolder.setUserProfile(R.drawable.default_anonymous_users_avatar);
            } else {
                qiushiHolder.setUserProfile(qb.getUserInfo().getIconDetailUrl());
            }
        }
        if(qb.getUserInfo() != null) {
            qiushiHolder.setUserName(qb.getUserInfo().getLogin());
        } else {
            qiushiHolder.setUserName("匿名用户");
        }

        Type popularStatus = qb.getQiushiText().getQiushiType();
        qiushiHolder.setPopularRate(popularStatus);
        qiushiHolder.setPopularDesc(popularStatus);

        qiushiHolder.setQiushiContent(qb.getQiushiText().getQiushiCoententBrief());
        int goodNo = qb.getQiushiText().getQiushiZan();
        int commentNo = qb.getQiushiText().getCommentCount();
        qiushiHolder.setQiushiSummary(goodNo, commentNo);
    }

    @Override
    public QiushiHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_single_qiushi, viewGroup, false);

        return new QiushiHolder(itemView, mContext);
    }
}
