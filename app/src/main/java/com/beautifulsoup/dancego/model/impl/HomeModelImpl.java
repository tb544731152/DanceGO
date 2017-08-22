package com.beautifulsoup.dancego.model.impl;

import android.content.Context;

import com.beautifulsoup.dancego.api.HttpManager;
import com.beautifulsoup.dancego.api.RetrofitManager;
import com.beautifulsoup.dancego.bean.Music;
import com.beautifulsoup.dancego.bean.Video;
import com.beautifulsoup.dancego.listener.GetDataListener;
import com.beautifulsoup.dancego.listener.HttpDataListener;
import com.beautifulsoup.dancego.model.HomeModel;
import com.beautifulsoup.dancego.network.RestService;

import retrofit2.Retrofit;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public class HomeModelImpl implements HomeModel {
    private Retrofit retrofit;
    private RestService restService;
    private GetDataListener videoDataListener;
    public HomeModelImpl(){
        retrofit= RetrofitManager.newRetrofit();
    }


    @Override
    public void getVideo(String url,Context context) {
        restService=retrofit.create(RestService.class);

        HttpManager.newInstance().with(context)
                .setObservable(restService.getVideo(url))
                .setDataListener(new HttpDataListener<Video>(){

                    @Override
                    public void onNext(Video video) {
                        if(null!=videoDataListener){
                            videoDataListener.getVideoData(video);
                        }
                    }
                });
    }

    @Override
    public void getMusic(String url, Context context) {
        restService=retrofit.create(RestService.class);

        HttpManager.newInstance().with(context)
                .setObservable(restService.getMusic(url))
                .setDataListener(new HttpDataListener<Music>(){

                    @Override
                    public void onNext(Music music) {
                        videoDataListener.getMusicData(music);
                    }
                });
    }

    @Override
    public void setVideoDataListener(GetDataListener videoDataListener) {
        this.videoDataListener=videoDataListener;
    }

}
