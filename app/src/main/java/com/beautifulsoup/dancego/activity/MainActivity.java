package com.beautifulsoup.dancego.activity;


import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.beautifulsoup.dancego.activity.base.BaseActivity;
import com.beautifulsoup.dancego.view.MainView;
import com.realfans.dancego.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements MainView{

    private ActionBar actionBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        actionBar=getSupportActionBar();
        if (null!=actionBar){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu_icon);
        }

        setSupportActionBar(toolbar);


    }

    @Override
    protected void processLogic() {

    }

    @Override
    protected Context getActivityContext() {
        return this;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMsg(String message) {

    }
}
