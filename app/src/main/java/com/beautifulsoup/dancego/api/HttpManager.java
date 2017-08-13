package com.beautifulsoup.dancego.api;

import android.content.Context;

import com.beautifulsoup.dancego.bean.RegisterResult;
import com.beautifulsoup.dancego.listener.HttpDataListener;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public class HttpManager {
    private volatile static HttpManager singleton;
    private WeakReference<Context> mContext;
    private SubscriberManager subscriberManager;
    private Observable observable;
    private boolean showProgress=true;

    private HttpManager(){
    }

    public static HttpManager newInstance(){
        if (singleton==null){
            synchronized (HttpManager.class){
                if(null==singleton){
                    singleton=new HttpManager();
                }
            }
        }
        return singleton;
    }

    public HttpManager with(Context context){
        this.mContext=new WeakReference<Context>(context);
        return singleton;
    }

    public HttpManager setObservable(Observable<RegisterResult<String>> observable){
        this.observable=observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).map(new ResultMap<String>());
        return singleton;
    }

    public void setDataListener(HttpDataListener dataListener){
        this.subscriberManager=new SubscriberManager(dataListener,mContext.get());
        observable.subscribe(subscriberManager);
    }

}
