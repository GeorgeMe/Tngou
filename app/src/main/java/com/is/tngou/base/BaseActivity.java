package com.is.tngou.base;

import android.support.v7.app.AppCompatActivity;

import com.is.tngou.mvp.view.BaseView;

/**
 * Created by George on 2016/7/11.
 */
public class BaseActivity extends AppCompatActivity implements BaseView{


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
