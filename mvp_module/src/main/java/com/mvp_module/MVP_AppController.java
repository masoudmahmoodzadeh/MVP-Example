package com.mvp_module;

import android.content.Context;
import android.support.multidex.MultiDexApplication;
import android.view.LayoutInflater;

import com.mvp_module.interfaces.MVP_IApp;
import com.mvp_module.interfaces.MVP_IBaseRepository;


public abstract class MVP_AppController extends MultiDexApplication
        implements MVP_IApp, MVP_IBaseRepository {

    private int widthScreen = -1, heightScreen = -1;
    private LayoutInflater layoutInflater;
    protected boolean isNetworkAvailable;

    @Override
    public MVP_BaseUtils provideUtils() {

        return MVP_BaseUtils.getInstance(this);

    }

    @Override
    public MVP_AnimationUtils animationUtils() {
        return MVP_AnimationUtils.getInstance() ;
    }

    @Override
    public int getWidthDevice() {

        if (widthScreen == -1)
            widthScreen = provideUtils().getScreenSize(true);

        return widthScreen;
    }

    @Override
    public int getHeightDevice() {

        if (heightScreen == -1)
            heightScreen = provideUtils().getScreenSize(false);

        return heightScreen;
    }

    @Override
    public LayoutInflater provideLayoutInflater() {

        if (layoutInflater == null)
            layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return layoutInflater;
    }

    @Override
    public void log(String nameClass, String methodName, Exception error) {

        provideUtils().log(nameClass, methodName, error);
    }

    public void setNetworkAvailable(boolean isNetworkAvailable) {
        this.isNetworkAvailable = isNetworkAvailable;
    }



}
