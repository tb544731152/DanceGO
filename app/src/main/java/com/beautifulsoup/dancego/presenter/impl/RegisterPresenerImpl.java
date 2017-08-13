package com.beautifulsoup.dancego.presenter.impl;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.beautifulsoup.dancego.api.HttpManager;
import com.beautifulsoup.dancego.api.RetrofitManager;
import com.beautifulsoup.dancego.bean.RegisterResult;
import com.beautifulsoup.dancego.listener.HttpDataListener;
import com.beautifulsoup.dancego.network.RegisterService;
import com.beautifulsoup.dancego.presenter.RegisterPresenter;
import com.beautifulsoup.dancego.utils.ConstantConfig;
import com.beautifulsoup.dancego.view.RegisterView;
import com.realfans.dancego.R;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public class RegisterPresenerImpl implements RegisterPresenter {

    public static final String REQUIST_PATH="register";


    private RegisterView registerView;
    private Context context;


    private Retrofit retrofit;

    public RegisterPresenerImpl(RegisterView registerView, Context context) {
        this.registerView = registerView;
        this.retrofit= RetrofitManager.newRetrofit();
        this.context=context;
    }

    @Override
    public boolean checkValidatedInfo(String username, String phone, String password, String age,boolean male) {
        if (username.length()<1||username.length()>20){
            registerView.setRg_usernameWapperError();
            return false;
        }else{
            registerView.close_usernameWrapperError();
        }
        if(phone.length()!=11){
            registerView.setRg_phoneWapperError();
            return false;
        }else {
            registerView.close_phoneWrapperError();
        }
        if(password.length()<8||password.length()>30){
            registerView.setRg_passwordWapperError();
            return false;
        }else {
            registerView.close_passwordWrapperError();
        }
        if (age.length()==0){
            registerView.setRg_ageWapperError();
            return false;
        }else if (Integer.parseInt(age)<0||Integer.parseInt(age)>100){
            registerView.setRg_ageWapperError();
            return false;
        }else {
            registerView.close_ageWrapperError();
        }
        return true;
    }

    @Override
    public void registUser(String username, String phone, String password, String age, String sex) {
        final RegisterService registerService=retrofit.create(RegisterService.class);

        HttpManager.newInstance().with(context).setObservable(
                registerService.registerUser(ConstantConfig.BASE_URL+REQUIST_PATH,username,phone,sex,age,password)
        ).setDataListener(new HttpDataListener<RegisterResult<String>>(){
            @Override
            public void onNext(RegisterResult<String> response) {
                String result=response.getResult();
                if(result.equals(ConstantConfig.REGISTER_SUCCESS)){
                    Toast.makeText(context,"恭喜,注册成功!",Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            registerView.gotoLoginActivity();
                        }
                    },2000);
                }else{
                    Toast.makeText(context,"对不起注册失败。"+response.getError(),Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}
