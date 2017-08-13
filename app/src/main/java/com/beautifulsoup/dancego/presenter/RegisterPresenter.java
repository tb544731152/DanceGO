package com.beautifulsoup.dancego.presenter;

import com.beautifulsoup.dancego.presenter.base.BasePresenter;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public interface RegisterPresenter extends BasePresenter {
    boolean checkValidatedInfo(String username,String phone,String password,String age,boolean male);

    void registUser(String username,String phone,String password,String age,String sex);
}
