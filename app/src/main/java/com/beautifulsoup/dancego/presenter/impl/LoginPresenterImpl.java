package com.beautifulsoup.dancego.presenter.impl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.beautifulsoup.dancego.api.HttpManager;
import com.beautifulsoup.dancego.api.RetrofitManager;
import com.beautifulsoup.dancego.bean.LoginResult;
import com.beautifulsoup.dancego.listener.HttpDataListener;
import com.beautifulsoup.dancego.network.LoginService;
import com.beautifulsoup.dancego.presenter.LoginPresenter;
import com.beautifulsoup.dancego.utils.ConstantConfig;
import com.beautifulsoup.dancego.view.LoginView;

import retrofit2.Retrofit;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class LoginPresenterImpl implements LoginPresenter {
    public static final String TAG="LoginPresenterImpl";
    public static final String REQUEST_PATH="login";
    private Context mContext;
    private LoginView loginView;

    private Retrofit retrofit;

    public LoginPresenterImpl(LoginView loginView,Context mContext){
        this.loginView=loginView;
        this.mContext=mContext;
        this.retrofit= RetrofitManager.newRetrofit();
    }

    @Override
    public void login(String phonenum, final String password) {
        final LoginService loginService=retrofit.create(LoginService.class);

        HttpManager.newInstance().with(mContext)
                .setObservable(loginService.loginUser(ConstantConfig.BASE_URL+REQUEST_PATH,phonenum,password))
                .setDataListener(new HttpDataListener<LoginResult>(){

                    @Override
                    public void onNext(final LoginResult response) {
                        String result=response.getResult();
                        if (result.equals(ConstantConfig.SUCCESS)){
                            Log.i(TAG, "--"+response.getData().getToken());
                            Toast.makeText(mContext,"登录成功",Toast.LENGTH_SHORT).show();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Bundle bundle=new Bundle();
                                    bundle.putString(ConstantConfig.PASSWORD,password);
//                                    bundle.putParcelable(ConstantConfig.USER_INFO,response);
                                    bundle.putString(ConstantConfig.USERNAME,response.getData().getUsername());
                                    bundle.putString(ConstantConfig.PHONENUM,response.getData().getPhonenum());
                                    bundle.putString(ConstantConfig.TOKEN,response.getData().getToken());
                                    loginView.gotoMainActivity(bundle);
                                }
                            },2000);
                        }else if(result.equals(ConstantConfig.FAILURE)&&response.getError()!=null){
                            Toast.makeText(mContext,"登录失败。"+response.getError(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }


}
