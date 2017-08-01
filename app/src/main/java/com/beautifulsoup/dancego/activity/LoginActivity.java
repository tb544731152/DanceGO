package com.beautifulsoup.dancego.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

import com.beautifulsoup.dancego.activity.base.BaseActivity;
import com.beautifulsoup.dancego.view.LoginView;
import com.realfans.dancego.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public class LoginActivity extends BaseActivity implements LoginView{

    @BindView(R.id.tv_register)
    TextView tv_register;


    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @Override
    protected void setListener() {

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


    @OnClick(R.id.tv_register)
    public void gotoRegister(){
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }




}
