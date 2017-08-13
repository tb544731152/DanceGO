package com.beautifulsoup.dancego.activity;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.beautifulsoup.dancego.activity.base.BaseActivity;
import com.beautifulsoup.dancego.presenter.RegisterPresenter;
import com.beautifulsoup.dancego.presenter.impl.RegisterPresenerImpl;
import com.beautifulsoup.dancego.utils.ResourceUtil;
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
    @BindView(R.id.rb_male)
    RadioButton rb_male;

    @BindView(R.id.btn_register)
    Button btn_register;

    private RegisterPresenter registerPresenter;

    private String username;
    private String password;
    private String phone;
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
        registerPresenter=new RegisterPresenerImpl(this,getActivityContext());
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
        age=rg_ageWrapper.getEditText().getText().toString();

        boolean result=registerPresenter.checkValidatedInfo(username,phone,password,age,rb_male.isChecked());

        if (result){
            //此时说明验证成功
            if(rb_male.isChecked()){
                //此时是男
                registerPresenter.registUser(username,phone,password,age,"0");
            }else{
                //此时是女
                registerPresenter.registUser(username,phone,password,age,"1");
            }
        }
    }


    @Override
    public void setRg_usernameWapperError() {
        rg_usernameWapper.setError(ResourceUtil.getString(R.string.rg_username_error));
    }



    @Override
    public void setRg_phoneWapperError() {
        rg_phoneWrapper.setError(ResourceUtil.getString(R.string.rg_phone_error));
    }

    @Override
    public void setRg_passwordWapperError() {
        rg_passwordWrapper.setError(ResourceUtil.getString(R.string.rg_password_error));
    }

    @Override
    public void setRg_ageWapperError() {
        rg_ageWrapper.setError(ResourceUtil.getString(R.string.rg_age_error));
    }

    @Override
    public void close_usernameWrapperError() {
        rg_usernameWapper.setErrorEnabled(false);
    }

    @Override
    public void close_phoneWrapperError() {
        rg_phoneWrapper.setErrorEnabled(false);
    }

    @Override
    public void close_passwordWrapperError() {
        rg_passwordWrapper.setErrorEnabled(false);
    }

    @Override
    public void close_ageWrapperError() {
        rg_ageWrapper.setErrorEnabled(false);
    }

    @Override
    public void gotoLoginActivity() {
        this.finish();
    }
}
