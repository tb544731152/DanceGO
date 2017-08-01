package com.beautifulsoup.dancego.activity;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.Toast;

import com.beautifulsoup.dancego.activity.base.BaseActivity;
import com.beautifulsoup.dancego.presenter.RegisterPresenter;
import com.beautifulsoup.dancego.presenter.impl.RegisterPresenerImpl;
import com.beautifulsoup.dancego.view.RegisterView;
import com.realfans.dancego.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public class RegisterActivity extends BaseActivity implements RegisterView{

    @BindView(R.id.rg_usernameWappper)
    TextInputLayout rg_usernameWapper;
    @BindView(R.id.rg_passwordWrapper)
    TextInputLayout rg_passwordWrapper;
    @BindView(R.id.rg_phoneWrapper)
    TextInputLayout rg_phoneWrapper;
    @BindView(R.id.rg_ageWrapper)
    TextInputLayout rg_ageWrapper;
    @BindView(R.id.rg_sexWrapper)
    TextInputLayout rg_sexWrapper;
    @BindView(R.id.btn_register)
    Button btn_register;

    private RegisterPresenter registerPresenter;

    private String username;
    private String password;
    private String phone;
    private String sex;
    private String age;

    @Override
    protected void loadViewLayout() {
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic() {
        registerPresenter=new RegisterPresenerImpl();
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

    @OnClick(R.id.btn_register)
    public void register(){
        username=rg_usernameWapper.getEditText().getText().toString();
        password=rg_passwordWrapper.getEditText().getText().toString();
        phone=rg_phoneWrapper.getEditText().getText().toString();
        sex=rg_sexWrapper.getEditText().getText().toString();
        age=rg_ageWrapper.getEditText().getText().toString();

        Toast.makeText(RegisterActivity.this,"username:"+username+",password:")

    }


}
