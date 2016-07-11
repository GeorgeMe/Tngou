package com.is.tngou.mvp.presenter;

import com.is.tngou.entity.GalleryDetail;
import com.is.tngou.mvp.interactor.GalleryDetailInteractor;
import com.is.tngou.mvp.listeners.BaseSingleLoadedListener;
import com.is.tngou.mvp.view.GalleryDetailView;

import org.json.JSONObject;

/**
 * Created by George on 2016/7/11.
 */
public class GalleryDetailPresenterImpl implements BaseSingleLoadedListener<GalleryDetail> {
    private GalleryDetailInteractor galleryDetailInteractor;
    private GalleryDetailView galleryDetailView;

    public GalleryDetailPresenterImpl(GalleryDetailView galleryDetailView) {
        this.galleryDetailView = galleryDetailView;
        galleryDetailInteractor=new GalleryDetailInteractor(this);
    }

    public void getGalleryDetail(JSONObject json){
        galleryDetailView.showLoading(null);
        galleryDetailInteractor.getCommonSingleData(json);
    }
    @Override
    public void onSuccess(GalleryDetail data) {
        galleryDetailView.hideLoading();
        galleryDetailView.onGalleryDetail(data.getList());
    }

    @Override
    public void onFailure(String msg) {
        galleryDetailView.hideLoading();
        galleryDetailView.showError(msg);
    }
}
