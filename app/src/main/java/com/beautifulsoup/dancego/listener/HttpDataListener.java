package com.beautifulsoup.dancego.listener;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public interface HttpDataListener<T> {
    void onNext(T t);
}
