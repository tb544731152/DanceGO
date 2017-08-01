package com.beautifulsoup.dancego.api;

import com.beautifulsoup.dancego.utils.ConstantConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public class RetrofitManager {

    //静态内部类的方式创建单例
    private volatile static RetrofitManager singleton;
    private Retrofit retrofit;

    public static RetrofitManager newInstance(){
        if (null==singleton){
            synchronized (RetrofitManager.class){
                if (null==singleton){
                    singleton=new RetrofitManager();
                }
            }
        }
        return singleton;
    }

    private RetrofitManager(){
        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.connectTimeout(ConstantConfig.NET_TIME_OUT, TimeUnit.SECONDS);
        retrofit=new Retrofit.Builder()
                .baseUrl(ConstantConfig.BASE_URL)
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public static Retrofit newRetrofit(){
        return newInstance().retrofit;
    }

}
