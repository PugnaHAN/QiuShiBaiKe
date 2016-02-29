package com.hp.qiushibaike.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.adapter.QiushiAdapter;
import com.hp.qiushibaike.item.QiushiBrief;
import com.hp.qiushibaike.utils.LogUtils;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/26.
 */
public class QiuShiListFragment extends Fragment {
    private static final String TAG = LogUtils.makeLogTag(QiuShiListFragment.class);

    private RecyclerView mQiushiRecyclerView;
    private ArrayList<QiushiBrief> mQiushiBriefs;
    private QiushiAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initData();
        mAdapter = new QiushiAdapter(mQiushiBriefs);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState ){
        View view = inflater.inflate(R.layout.content_main, parent, false);
        mQiushiRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_main);
        mQiushiRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        mQiushiRecyclerView.setLayoutManager(llm);
        mQiushiRecyclerView.setAdapter(mAdapter);

        return view;
    }

    private void initData(){
        mQiushiBriefs = new ArrayList<>();
        mQiushiBriefs.add(new QiushiBrief());
        mQiushiBriefs.add(new QiushiBrief());
        mQiushiBriefs.add(new QiushiBrief());
    }
}
