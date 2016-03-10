package com.hp.qiushibaike.ui.fragments;

import android.os.Handler;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.hp.qiushibaike.Constants;
import com.hp.qiushibaike.adapter.QiushiAdapter;
import com.hp.qiushibaike.info.UserInfo;
import com.hp.qiushibaike.item.QiushiItem;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by zhangjuh on 2016/2/26.
 */
public class QiuShiListFragment extends BaseListFragment {
    private static final String TAG = LogUtils.makeLogTag(QiuShiListFragment.class);

    private int mCurrentPage = 0;

    // TODO: use the network task to replace them
    @Override
    protected void getData(){
        if(mQiushiItems == null) {
            mQiushiItems = new ArrayList<>();
        }
        getQiushiItems(mCurrentPage);
    }

    @Override
    protected void updateData(){
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                mCurrentPage++;
                Log.d(TAG, "current page is " + mCurrentPage);
                getQiushiItems(mCurrentPage);
                mQiushiRecyclerView.setAdapter(new QiushiAdapter(mQiushiItems));
                mSwipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    private void getQiushiItems(int page){
        RequestQueue queue =  Volley.newRequestQueue(getContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(getTextUrl(page), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray;
                        try {
                            jsonArray = response.getJSONArray("items");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                // Log.d(TAG, "Current json data is: " + jsonArray.getJSONObject(i));
                                mQiushiItems.add(new QiushiItem(jsonArray.getJSONObject(i)));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e(TAG, volleyError.getMessage(), volleyError);
            }
        });
        queue.add(jsonObjectRequest);
    }

    private String getTextUrl(int page){
        return page==0? Constants.TEXT : Constants.TEXT + "?page=" + page;
    }
}
