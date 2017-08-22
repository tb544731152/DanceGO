package com.beautifulsoup.dancego.utils;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.beautifulsoup.dancego.App;

/**
 * Created by BeautifulSoup on 2017/8/2.
 */

public class ResourceUtil {

    public static String getString(int resource_id){
       return App.getContext().getString(resource_id);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public static int getColor(int resource_id){
        return App.getContext().getColor(resource_id);
    }

    public static float px2dp(Context context,float pxVal){
        float scale=context.getResources().getDisplayMetrics().density;
        return pxVal/scale;
    }

    public static float px2sp(Context context,float pxVal){
        float density=context.getResources().getDisplayMetrics().scaledDensity;
        return pxVal/density;
    }

    public static float dp2px(Context context,int dpVal){
        float dentisy=context.getResources().getDisplayMetrics().density;
        return dpVal*dentisy;
    }

    public static float sp2px(Context context,float spVal){
        float scale=context.getResources().getDisplayMetrics().scaledDensity;
        return scale*spVal;
    }
}
