package com.beautifulsoup.dancego.presenter.impl;

import android.content.Context;
import android.util.Log;

import com.beautifulsoup.dancego.bean.Music;
import com.beautifulsoup.dancego.bean.Video;
import com.beautifulsoup.dancego.listener.GetDataListener;
import com.beautifulsoup.dancego.model.HomeModel;
import com.beautifulsoup.dancego.model.impl.HomeModelImpl;
import com.beautifulsoup.dancego.presenter.HomePresenter;
import com.beautifulsoup.dancego.view.HomeView;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public class HomePresenterImpl implements HomePresenter {

    private static final String TAG="HomePresenterImpl";
    private HomeView homeView;
    private Context mContext;

    private HomeModel homeModel=null;


    public HomePresenterImpl(final HomeView homeView, Context context){
        this.homeView=homeView;
        this.mContext=context;

        homeModel=new HomeModelImpl();

        homeModel.setVideoDataListener(new GetDataListener() {
            @Override
            public void getVideoData(Video video) {
//                Log.i(TAG, video.getData().toString());
                homeView.setLearnDanceData(video);

            }

            @Override
            public void getMusicData(Music music) {
                homeView.setSongListData(music);
            }
        });
    }


    @Override
    public void getVideo(String url) {
        homeModel.getVideo(url,mContext);
    }

    @Override
    public void getMusic(String url) {
        homeModel.getMusic(url,mContext);
    }


}
