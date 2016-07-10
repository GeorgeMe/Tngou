package com.is.tngou.mvp.interactor;

import com.is.tngou.base.Retrofit2Tngou;
import com.is.tngou.entity.Gallery;
import com.is.tngou.mvp.listeners.BaseMultiLoadedListener;
import com.is.tngou.mvp.listeners.CommonListInteractor;
import com.is.tngou.protocol.GalleryResponse;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by George on 2016/7/11.
 */
public class GalleryInteractor extends Retrofit2Tngou implements CommonListInteractor{
    private BaseMultiLoadedListener<List<Gallery>> loadedListener;

    public GalleryInteractor(BaseMultiLoadedListener<List<Gallery>> loadedListener) {
        this.loadedListener = loadedListener;
    }

    @Override
    public void getCommonListData(final int event, JSONObject json) {
        Call<GalleryResponse> call = tngouApi.GalleryList(
                (Number) json.opt("id"),
                (Number) json.opt("page"),
                (Number) json.opt("rows"));
        call.enqueue(new Callback<GalleryResponse>() {
            @Override
            public void onResponse(Call<GalleryResponse> call, Response<GalleryResponse> response) {
                loadedListener.onSuccess(event,response.body().getTngou());
            }

            @Override
            public void onFailure(Call<GalleryResponse> call, Throwable t) {

            }
        });
    }
}
