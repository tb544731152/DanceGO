package com.beautifulsoup.dancego.network;

import com.beautifulsoup.dancego.bean.LogoutResult;

import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by BeautifulSoup on 2017/8/13.
 */

public interface LogoutService {


    @POST
    Observable<LogoutResult> logoutUser(@Url String url, @Header("phonenum")String phonenum,@Header("token")String token);



}
