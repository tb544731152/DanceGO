package com.beautifulsoup.dancego.presenter.base;

import com.beautifulsoup.dancego.view.base.BaseView;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public interface BasePresenter {
    void onCreate();
    void attachView(BaseView view);
    void Destory();
}
