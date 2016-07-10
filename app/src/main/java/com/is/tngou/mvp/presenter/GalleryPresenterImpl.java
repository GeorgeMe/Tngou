package com.is.tngou.mvp.presenter;

import com.is.tngou.entity.Gallery;
import com.is.tngou.mvp.interactor.GalleryInteractor;
import com.is.tngou.mvp.listeners.BaseMultiLoadedListener;
import com.is.tngou.mvp.view.GalleryView;

import java.util.List;

/**
 * Created by George on 2016/7/11.
 */
public class GalleryPresenterImpl implements BaseMultiLoadedListener<List<Gallery>>{
    private GalleryInteractor galleryInteractor;
    private GalleryView galleryView;

    public GalleryPresenterImpl(GalleryView galleryView) {
        this.galleryView = galleryView;
        galleryInteractor=new GalleryInteractor(this);
    }

    @Override
    public void onSuccess(int event_tag, List<Gallery> data) {
        galleryView.hideLoading();
    }

    @Override
    public void onFailure(String msg) {
        galleryView.hideLoading();
        galleryView.showError(msg);
    }
}
