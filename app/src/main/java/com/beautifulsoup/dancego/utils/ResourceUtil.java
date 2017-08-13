package com.beautifulsoup.dancego.utils;

import android.content.Context;

import com.beautifulsoup.dancego.App;

/**
 * Created by BeautifulSoup on 2017/8/2.
 */

public class ResourceUtil {

    public static String getString(int resource_id){
       return App.getContext().getString(resource_id);
    }
}
