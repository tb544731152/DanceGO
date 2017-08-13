package com.beautifulsoup.dancego;

import android.app.Application;
import android.content.Context;

/**
 * Created by BeautifulSoup on 2017/7/31.
 */

public class App extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=this;
    }

    public static Context getContext(){
        return mContext;
    }
}
