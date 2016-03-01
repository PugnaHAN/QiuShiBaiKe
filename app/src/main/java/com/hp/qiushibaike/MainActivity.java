package com.hp.qiushibaike;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hp.qiushibaike.ui.fragments.QiuShiListFragment;
import com.hp.qiushibaike.utils.LogUtils;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = LogUtils.makeLogTag(MainActivity.class);

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
}
