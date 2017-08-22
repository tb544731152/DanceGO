package com.beautifulsoup.dancego.listener;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public interface ProgressResponseListener {

    void onResponseProgress(long bytesRead,long contentLength);
}
