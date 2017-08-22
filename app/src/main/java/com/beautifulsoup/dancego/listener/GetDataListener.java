package com.beautifulsoup.dancego.listener;

import com.beautifulsoup.dancego.bean.Music;
import com.beautifulsoup.dancego.bean.Video;

/**
 * Created by BeautifulSoup on 2017/8/14.
 */

public interface GetDataListener {
    void getVideoData(Video video);
    void getMusicData(Music music);
}
