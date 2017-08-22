package com.beautifulsoup.dancego.presenter;

import com.beautifulsoup.dancego.bean.Video;
import com.beautifulsoup.dancego.presenter.base.BasePresenter;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public interface HomePresenter extends BasePresenter {

    void getVideo(String url);
    void getMusic(String url);
}
