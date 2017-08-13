package com.beautifulsoup.dancego.view;

import com.beautifulsoup.dancego.view.base.BaseView;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public interface RegisterView extends BaseView {
    void setRg_usernameWapperError();
    void setRg_phoneWapperError();
    void setRg_passwordWapperError();
    void setRg_ageWapperError();

    void close_usernameWrapperError();
    void close_phoneWrapperError();
    void close_passwordWrapperError();
    void close_ageWrapperError();

    void gotoLoginActivity();

}
