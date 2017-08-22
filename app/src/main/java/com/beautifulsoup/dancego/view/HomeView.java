package com.beautifulsoup.dancego.view;

import com.beautifulsoup.dancego.bean.Music;
import com.beautifulsoup.dancego.bean.Video;
import com.beautifulsoup.dancego.view.base.BaseView;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public interface HomeView extends BaseView {

    void getVideo(String url);
    void getMusic(String url);

    void setLearnDanceData(Video video);
    void setSongListData(Music music);
}
