package com.mvp_module.interfaces;

import android.support.annotation.StringRes;

import com.mvp_module.MVP_BaseActivity;


public interface MVP_IBaseView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

    MVP_BaseActivity getBaseActivity();

    String getUniqueTag();

}
