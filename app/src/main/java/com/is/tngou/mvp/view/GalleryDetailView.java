package com.is.tngou.mvp.view;

import com.is.tngou.entity.GalleryDetail;

import java.util.List;

/**
 * Created by George on 2016/7/11.
 */
public interface GalleryDetailView extends BaseView {
    void onGalleryDetail(List<GalleryDetail.GalleryList> galleryLists);
}
