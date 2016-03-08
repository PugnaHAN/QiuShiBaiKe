package com.hp.qiushibaike;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.hp.qiushibaike.ui.fragments.QiuShiListFragment;
import com.hp.qiushibaike.utils.LogUtils;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = LogUtils.makeLogTag(MainActivity.class);

    private static final String QIUBAI_URL = "http://www.qiushibaike.com/";

    private static final String[] sTabTitles = {
        "专享", "视频", "纯文", "纯图", "精华"
    };
    private TabLayout mTitleTabLayout;
    private ViewPager mContentViewPager;

    ArrayList<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initFragments();
        FragmentManager fm = getSupportFragmentManager();

        mContentViewPager = (ViewPager) findViewById(R.id.content_view_pager);
        mContentViewPager.setAdapter(new FragmentPagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return 5;
            }
        });

        mTitleTabLayout = (TabLayout) findViewById(R.id.title_tab);
        mTitleTabLayout.setupWithViewPager(mContentViewPager);
        mTitleTabLayout.setTabMode(TabLayout.MODE_FIXED);

        for(int i = 0; i < mTitleTabLayout.getTabCount(); i++){
            TabLayout.Tab tab = mTitleTabLayout.getTabAt(i);
            if(tab != null){
                tab.setText(sTabTitles[i]);
            }
        }

        httpTaskGet();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initFragments(){
        for(int i = 0; i < 5; i++){
            mFragments.add(new QiuShiListFragment());
        }
    }

    private void httpTaskGet(){
        RequestQueue queue = Volley.newRequestQueue(this);

//        StringRequest stringRequest = new StringRequest(QIUBAI_URL,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Log.d(TAG, response);
//                    }
//                }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e(TAG, error.getMessage(), error);
//            }
//        });

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("http://m2.qiushibaike.com/article/list/day", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
            }
        });


        // queue.add(stringRequest);
        queue.add(jsonObjectRequest);
    }
}
