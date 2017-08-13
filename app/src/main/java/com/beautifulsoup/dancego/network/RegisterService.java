package com.beautifulsoup.dancego.network;

import com.beautifulsoup.dancego.bean.RegisterResult;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by BeautifulSoup on 2017/8/1.
 */

public interface RegisterService {

    @FormUrlEncoded
    @POST
    Observable<RegisterResult<String>> registerUser(@Url String url, @FieldMap Map<String,String> params);

}
