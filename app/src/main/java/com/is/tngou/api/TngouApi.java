package com.is.tngou.api;
import com.is.tngou.entity.GalleryDetail;
import com.is.tngou.protocol.GalleryClassResponse;
import com.is.tngou.protocol.GalleryResponse;
import com.is.tngou.protocol.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
/**
 * Created by George on 2016/7/10.
 */
public interface TngouApi {

    @GET("classify")
    Call<GalleryClassResponse> GalleryClassify();

    @GET("list")
    Call<GalleryResponse> GalleryList(@Query("id") Number id, @Query("page") Number page, @Query("rows") Number rows);

    @GET("show")
    Call<GalleryDetail> GalleryDetail(@Query("id") Number id);

    @GET("news")
    Call<NewsResponse> NewsList(@Query("id") Number id, @Query("rows") Number rows, @Query("classify") Number classify);

}
