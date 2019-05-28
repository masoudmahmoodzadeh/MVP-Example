package com.mvp_module.interfaces;

import android.view.LayoutInflater;

import com.mvp_module.MVP_AnimationUtils;
import com.mvp_module.MVP_BaseUtils;


public interface MVP_IApp {

    boolean isNetworkConnected();

    MVP_BaseUtils provideUtils();

    int getWidthDevice();

    int getHeightDevice();

    LayoutInflater provideLayoutInflater();

    void log(String nameClass, String methodName, Exception error);

    MVP_AnimationUtils animationUtils();
}
