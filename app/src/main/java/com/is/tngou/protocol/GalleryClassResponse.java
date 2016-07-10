package com.is.tngou.protocol;

import com.is.tngou.entity.GalleryClass;

import java.util.List;

/**
 * Created by George on 2016/7/10.
 */
public class GalleryClassResponse {

    private boolean status;

    private List<GalleryClass> tngou;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<GalleryClass> getTngou() {
        return tngou;
    }

    public void setTngou(List<GalleryClass> tngou) {
        this.tngou = tngou;
    }


}
