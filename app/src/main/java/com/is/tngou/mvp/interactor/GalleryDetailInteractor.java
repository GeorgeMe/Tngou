package com.is.tngou.mvp.interactor;

import com.is.tngou.base.Retrofit2Tngou;
import com.is.tngou.entity.GalleryDetail;
import com.is.tngou.mvp.listeners.BaseSingleLoadedListener;
import com.is.tngou.mvp.listeners.CommonSingleInteractor;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/7/11.
 */
public class GalleryDetailInteractor extends Retrofit2Tngou implements CommonSingleInteractor {
    private BaseSingleLoadedListener<GalleryDetail> loadedListener;

    public GalleryDetailInteractor(BaseSingleLoadedListener<GalleryDetail> loadedListener) {
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {
        Call<GalleryDetail> call = tngouApi.GalleryDetail((Number) json.opt("id"));
        call.enqueue(new Callback<GalleryDetail>() {
            @Override
            public void onResponse(Call<GalleryDetail> call, Response<GalleryDetail> response) {
                loadedListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<GalleryDetail> call, Throwable t) {

            }
        });
    }
}
