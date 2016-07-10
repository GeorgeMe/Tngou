package com.is.tngou.mvp.presenter;

import com.is.tngou.entity.GalleryClass;
import com.is.tngou.mvp.interactor.GalleryClassInteractor;
import com.is.tngou.mvp.listeners.BaseSingleLoadedListener;
import com.is.tngou.mvp.view.GalleryClassView;

import java.util.List;

/**
 * Created by George on 2016/7/11.
 */
public class GalleryClassPresenterImpl implements BaseSingleLoadedListener<List<GalleryClass>>{

    private GalleryClassInteractor galleryClassInteractor;
    private GalleryClassView galleryClassView;

    public GalleryClassPresenterImpl(GalleryClassView galleryClassView) {
        this.galleryClassView = galleryClassView;
        galleryClassInteractor=new GalleryClassInteractor(this);
    }

    @Override
    public void onSuccess(List<GalleryClass> data) {
        galleryClassView.hideLoading();
    }

    @Override
    public void onFailure(String msg) {
        galleryClassView.hideLoading();
        galleryClassView.showError(msg);
    }
}
