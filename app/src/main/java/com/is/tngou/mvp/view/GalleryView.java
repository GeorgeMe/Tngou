package com.is.tngou.mvp.view;

import com.is.tngou.entity.Gallery;

import java.util.List;

/**
 * Created by George on 2016/7/11.
 */
public interface GalleryView extends BaseView {
    void onGalleryPhotoList(List<Gallery> data);
}
