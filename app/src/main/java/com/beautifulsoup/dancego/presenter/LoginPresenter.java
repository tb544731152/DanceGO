package com.beautifulsoup.dancego.presenter;

import com.beautifulsoup.dancego.presenter.base.BasePresenter;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public interface LoginPresenter extends BasePresenter {
    void login(String phonenum,String password);
}
