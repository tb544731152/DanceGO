package com.beautifulsoup.dancego.network;

import com.beautifulsoup.dancego.bean.GroupList;
import com.beautifulsoup.dancego.bean.Music;
import com.beautifulsoup.dancego.bean.Video;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by BeautifulSoup on 2017/8/2.
 */

public interface RestService {

    @GET
    Call<String> get(@Url String url, @QueryMap Map<String,Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String,Object> params);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url,@FieldMap Map<String,Object> params);

    @DELETE
    Call<String> delete(@Url String url,@QueryMap Map<String,Object> params);

    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url,@QueryMap Map<String,Object> params);

    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);


    @GET
    Observable<Video> getVideo(@Url String url);

    @GET
    Observable<Music> getMusic(@Url String url);

    @GET
    Observable<GroupList> getGroupList(@Url String url, @Header("phonenum")String phonenum,@Header("token")String token);


}
