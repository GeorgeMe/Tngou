package com.is.tngou.mvp.interactor;

import com.is.tngou.base.Retrofit2Tngou;
import com.is.tngou.entity.GalleryClass;
import com.is.tngou.mvp.listeners.BaseSingleLoadedListener;
import com.is.tngou.mvp.listeners.CommonSingleInteractor;
import com.is.tngou.protocol.GalleryClassResponse;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/7/11.
 */
public class GalleryClassInteractor extends Retrofit2Tngou implements CommonSingleInteractor{
    private BaseSingleLoadedListener<List<GalleryClass>> loadedListener;

    public GalleryClassInteractor(BaseSingleLoadedListener<List<GalleryClass>> loadedListener) {
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonSingleData(JSONObject json) {
        Call<GalleryClassResponse> call = tngouApi.GalleryClassify();
        call.enqueue(new Callback<GalleryClassResponse>() {
            @Override
            public void onResponse(Call<GalleryClassResponse> call, Response<GalleryClassResponse> response) {
                loadedListener.onSuccess(response.body().getTngou());
            }

            @Override
            public void onFailure(Call<GalleryClassResponse> call, Throwable t) {

            }
        });
    }
}
