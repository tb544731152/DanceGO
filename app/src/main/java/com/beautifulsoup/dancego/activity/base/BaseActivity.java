package com.beautifulsoup.dancego.activity.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.beautifulsoup.dancego.presenter.base.BasePresenter;
import com.beautifulsoup.dancego.utils.ActivityController;
import com.beautifulsoup.dancego.utils.ConstantConfig;

import butterknife.ButterKnife;

/**
 * Created by BeautifulSoup on 2017/7/31.
 */

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity {

    protected Context mContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivityContext();
        ActivityController.addActivity(this);
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
        ActivityController.removeActivity(this);
        super.onDestroy();
    }


    private void initView(){
        loadViewLayout();
        setListener();
    }
    private void initData(){
        processLogic();
    }

    protected abstract void loadViewLayout();
    protected abstract void setListener();
    protected abstract void processLogic();
    protected abstract Context getActivityContext();


}
