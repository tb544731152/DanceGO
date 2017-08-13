package com.beautifulsoup.dancego.api;

import com.beautifulsoup.dancego.bean.RegisterResult;

import rx.functions.Func1;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public class ResultMap<T> implements Func1<RegisterResult<T>,RegisterResult<T>> {

    @Override
    public RegisterResult<T> call(RegisterResult<T> tRegisterResult) {
        return tRegisterResult;
    }
}
