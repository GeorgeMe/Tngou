package com.is.tngou.mvp.view;

/**
 * Created by George on 2016/7/11.
 */
public interface BaseView {
    /**
     * show loading message
     *
     * @param msg
     */
    void showLoading(String msg);

    /**
     * hide loading
     */
    void hideLoading();

    /**
     * show error message
     */
    public void showError(String msg);

    /**
     * show exception message
     */
    void showException(String msg);
    /**
     * show toast message
     */
    void showToast(String msg);
}