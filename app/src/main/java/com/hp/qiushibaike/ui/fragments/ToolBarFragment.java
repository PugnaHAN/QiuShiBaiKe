package com.hp.qiushibaike.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.hp.qiushibaike.R;
import com.hp.qiushibaike.utils.LogUtils;

/**
 * Created by zhangjuh on 2016/2/25.
 */
public class ToolBarFragment extends Fragment {
    private static final String TAG = LogUtils.makeLogTag(ToolBarFragment.class);

    private ImageButton mQiushiBtn;
    private ImageButton mLocationBtn;
    private ImageButton mChatBtn;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup parent,
                             Bundle savedInstance){
        View v = inflater.inflate(R.layout.fragment_toolbar, parent, false);
        mQiushiBtn = (ImageButton) v.findViewById(R.id.qiushiImageBtn);
        mLocationBtn = (ImageButton) v.findViewById(R.id.campusImageBtn);
        mChatBtn = (ImageButton) v.findViewById(R.id.chatImageBtn);

        mQiushiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQiushiBtn.setBackgroundResource(R.color.colorPrimaryDark);
                mLocationBtn.setBackgroundResource(R.color.transparent);
                mChatBtn.setBackgroundResource(R.color.transparent);
            }
        });
        mLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQiushiBtn.setBackgroundResource(R.color.transparent);
                mLocationBtn.setBackgroundResource(R.color.colorPrimaryDark);
                mChatBtn.setBackgroundResource(R.color.transparent);
            }
        });
        mChatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQiushiBtn.setBackgroundResource(R.color.transparent);
                mLocationBtn.setBackgroundResource(R.color.transparent);
                mChatBtn.setBackgroundResource(R.color.colorPrimaryDark);
            }
        });
        return v;
    }
}
