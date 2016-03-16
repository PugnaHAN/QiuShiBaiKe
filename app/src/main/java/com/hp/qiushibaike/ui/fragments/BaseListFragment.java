package com.hp.qiushibaike.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.adapter.QiushiAdapter;
import com.hp.qiushibaike.item.QiushiItem;
import com.hp.qiushibaike.utils.LogUtils;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/3/1.
 */
public abstract class BaseListFragment extends Fragment {
    private static final String TAG = LogUtils.makeLogTag(BaseListFragment.class);

    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected RecyclerView mQiushiRecyclerView;

    protected QiushiAdapter mAdapter;
    protected ArrayList<QiushiItem> mQiushiItems;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getData();
        mAdapter = new QiushiAdapter(mQiushiItems, getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.content_main, parent, false);
        mQiushiRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_main);
        mQiushiRecyclerView.setHasFixedSize(true);

        final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mQiushiRecyclerView.setLayoutManager(llm);
        mQiushiRecyclerView.setAdapter(mAdapter);
        mQiushiRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE &&
                        llm.findLastVisibleItemPosition() == mAdapter.getItemCount() - 1){
                    updateData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateData();
            }
        });
        return view;
    }

    protected abstract void getData();

    protected abstract void updateData();
}
