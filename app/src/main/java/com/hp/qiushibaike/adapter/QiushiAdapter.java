package com.hp.qiushibaike.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.holder.QiushiHolder;
import com.hp.qiushibaike.info.QiushiDetailInfo;
import com.hp.qiushibaike.item.QiushiBrief;
import com.hp.qiushibaike.utils.LogUtils;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/29.
 */
public class QiushiAdapter extends RecyclerView.Adapter<QiushiHolder> {
    private static final String TAG = LogUtils.makeLogTag(QiushiAdapter.class);

    private ArrayList<QiushiBrief> mQiushiBriefsList;

    public QiushiAdapter(ArrayList<QiushiBrief> qiushiBriefs){
        mQiushiBriefsList = qiushiBriefs;
    }

    @Override
    public int getItemCount(){
        int count =  mQiushiBriefsList.size();
        // Log.d(TAG, "size is " + count);
        return count;
    }

    @Override
    public void onBindViewHolder(QiushiHolder qiushiHolder, int i){
        QiushiBrief qb = mQiushiBriefsList.get(i);
        qiushiHolder.setUserProfile(qb.getUserInfo().getProfilePath(), qb.getUserInfo().getGender());
        qiushiHolder.setUserName(qb.getUserInfo().getName());

        QiushiDetailInfo.PopularStatus popularStatus = qb.getQiushiDetailInfo().getPopularStatus();
        qiushiHolder.setPopularRate(popularStatus);
        qiushiHolder.setPopularDesc(popularStatus);

        qiushiHolder.setQiushiContent(qb.getQiushiDetailInfo().getQiushiCoententBrief());
        int goodNo = qb.getQiushiDetailInfo().getQiushiZan();
        int commentNo = qb.getQiushiDetailInfo().getComments().size();
        qiushiHolder.setQiushiSummary(goodNo, commentNo);
    }

    @Override
    public QiushiHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fragment_single_qiushi, viewGroup, false);

        return new QiushiHolder(itemView);
    }
}
