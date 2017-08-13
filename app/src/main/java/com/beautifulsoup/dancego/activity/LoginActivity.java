package com.beautifulsoup.dancego.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.beautifulsoup.dancego.activity.base.BaseActivity;
import com.beautifulsoup.dancego.presenter.LoginPresenter;
import com.beautifulsoup.dancego.presenter.impl.LoginPresenterImpl;
import com.beautifulsoup.dancego.utils.ConstantConfig;
import com.beautifulsoup.dancego.view.LoginView;
import com.realfans.dancego.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public class LoginActivity extends BaseActivity implements LoginView{


    @BindView(R.id.lg_phonenumWrapper)
    TextInputLayout lg_phonenumWrapper;

    @BindView(R.id.lg_passwordWrapper)
    TextInputLayout lg_passwordWrapper;

    @BindView(R.id.tv_register)
    TextView tv_register;
    @BindView(R.id.btn_login)
    Button btn_login;

    private String phonenum;
    private String password;

    private LoginPresenter loginPresenter;

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


        loginPresenter=new LoginPresenterImpl(this,getActivityContext());
    }

    @Override
    protected Context getActivityContext() {
        return this;
    }


    @OnClick(R.id.tv_register)
    public void gotoRegister(){
        Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_login)
    public void gotoLogin(){
        phonenum=lg_phonenumWrapper.getEditText().getText().toString();
        password=lg_passwordWrapper.getEditText().getText().toString();
        loginPresenter.login(phonenum,password);
    }


    @Override
    public void gotoMainActivity(Bundle data) {
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        intent.putExtras(data);
        startActivity(intent);
        this.finish();
    }


}
