package com.beautifulsoup.dancego.model;

import android.content.Context;

import com.beautifulsoup.dancego.listener.GetDataListener;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public interface HomeModel {
    void getVideo(String url, Context context);
    void getMusic(String url, Context context);
    void setVideoDataListener(GetDataListener videoDataListener);
}
