package com.is.tngou.mvp.listeners;

/**
 * Created by George on 2016/7/10.
 */
public interface BaseMultiLoadedListener<T> {

    /**
     * when data call back success
     *
     * @param event_tag
     * @param data
     */
    void onSuccess(int event_tag, T data);

    /**
     * when data call back error and when data call back occurred exception
     *
     * @param msg
     */
    void onFailure(String msg);

}