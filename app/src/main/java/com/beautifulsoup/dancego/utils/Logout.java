package com.beautifulsoup.dancego.utils;

import android.content.Context;
import android.widget.Toast;

import com.beautifulsoup.dancego.api.HttpManager;
import com.beautifulsoup.dancego.api.RetrofitManager;
import com.beautifulsoup.dancego.bean.LogoutResult;
import com.beautifulsoup.dancego.listener.HttpDataListener;
import com.beautifulsoup.dancego.network.LoginService;
import com.beautifulsoup.dancego.network.LogoutService;

import retrofit2.Retrofit;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class Logout {

    private static final String REQUEST_PATH="logout";
    private volatile static Logout singleton;


    private Context mContext;
    private Retrofit retrofit;

    private Logout(){

        retrofit= RetrofitManager.newRetrofit();


    }

    public static Logout newInstance(){
        if(null==singleton){
            synchronized (Logout.class){
                if(null==singleton){
                    singleton=new Logout();
                }
            }
        }
        return singleton;
    }

    public Logout with(Context context){
        this.mContext=context;
        return singleton;
    }

    public void logout(String userid,String token){
        LogoutService service=retrofit.create(LogoutService.class);
        HttpManager.newInstance().with(mContext)
                .setObservable(service.logoutUser(ConstantConfig.BASE_URL+REQUEST_PATH,userid,token))
                .setDataListener(new HttpDataListener<LogoutResult>(){
                    @Override
                    public void onNext(LogoutResult response) {
                        if(null!=response){
                            String result=response.getResult();
                            if (result.equals(ConstantConfig.SUCCESS)){
                                Toast.makeText(mContext,"您已经成功退出当前账号",Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(mContext,"当前账户已经登出",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

    }

}
