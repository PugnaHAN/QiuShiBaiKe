package com.hp.qiushibaike.ui.fragments;

import android.os.Handler;

import com.hp.qiushibaike.adapter.QiushiAdapter;
import com.hp.qiushibaike.info.UserInfo;
import com.hp.qiushibaike.item.QiushiBrief;
import com.hp.qiushibaike.utils.LogUtils;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/26.
 */
public class QiuShiListFragment extends BaseListFragment {
    private static final String TAG = LogUtils.makeLogTag(QiuShiListFragment.class);

    // TODO: use the network task to replace them
    @Override
    protected void getData(){
        mQiushiBriefs = new ArrayList<>();
        mQiushiBriefs.add(new QiushiBrief());
        QiushiBrief qiushiBrief = new QiushiBrief();
        qiushiBrief.getUserInfo().setGender(UserInfo.Gender.FEMALE);
        qiushiBrief.getUserInfo().setName("Saber");
        qiushiBrief.getQiushiDetailInfo().setCreateTime(60 * 1000 * 60 * 2);
        mQiushiBriefs.add(qiushiBrief);
        mQiushiBriefs.add(new QiushiBrief());
    }

    @Override
    protected void updateData(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                QiushiBrief qiushi = new QiushiBrief();
                qiushi.getUserInfo().setName("天王盖地虎");
                qiushi.getQiushiDetailInfo().setQiushiContent("从前有座山");
                qiushi.getUserInfo().setGender(UserInfo.Gender.FEMALE);
                mQiushiBriefs.add(qiushi);
                mQiushiRecyclerView.setAdapter(new QiushiAdapter(mQiushiBriefs));
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }
}
