package com.is.tngou.base;

import android.support.v4.app.Fragment;

import com.is.tngou.mvp.view.BaseView;

/**
 * Created by Administrator on 2016/7/11.
 */
public class BaseFragment extends Fragment implements BaseView{

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showException(String msg) {

    }

    @Override
    public void showToast(String msg) {

    }
}
