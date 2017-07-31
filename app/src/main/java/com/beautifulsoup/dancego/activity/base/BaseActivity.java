package com.beautifulsoup.dancego.activity.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by BeautifulSoup on 2017/7/31.
 */

public abstract class BaseActivity  extends AppCompatActivity {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivityContext();

        initView();
        initData();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



    private void initView(){
        loadViewLayout();
    }
    private void initData(){
        processLogic();
    }

    protected abstract void loadViewLayout();
    protected abstract void processLogic();
    protected abstract Context getActivityContext();
}
