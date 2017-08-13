package com.beautifulsoup.dancego.presenter.impl;

import com.beautifulsoup.dancego.presenter.RegisterPresenter;
import com.beautifulsoup.dancego.view.RegisterView;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public class RegisterPresenerImpl implements RegisterPresenter {

    private RegisterView registerView;

    public RegisterPresenerImpl(RegisterView registerView) {
        this.registerView = registerView;
    }

    @Override
    public boolean checkValidatedInfo(String username, String phone, String password, String age,boolean male) {
        if (username.length()<1||username.length()>20){
            registerView.setRg_usernameWapperError();
            return false;
        }
        if(phone.length()!=11){
            registerView.setRg_phoneWapperError();
            return false;
        }
        if(password.length()<8||password.length()>30){
            registerView.setRg_passwordWapperError();
            return false;
        }
        if (age.length()==0){
            registerView.setRg_ageWapperError();
            return false;
        }else if (Integer.parseInt(age)<0||Integer.parseInt(age)>100){
            registerView.setRg_ageWapperError();
            return false;
        }
//        if()
        return true;
    }
}
