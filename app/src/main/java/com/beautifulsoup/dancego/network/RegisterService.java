package com.beautifulsoup.dancego.network;

import com.beautifulsoup.dancego.bean.RegisterResult;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public interface RegisterService {

    @POST
    Observable<RegisterResult<String>> registerUser(@Url String url, @Header("username")String username,
                                                    @Header("phonenum")String phonenum,
                                                    @Header("sex")String sex,
                                                    @Header("age")String age,
                                                    @Header("password")String password);



}
