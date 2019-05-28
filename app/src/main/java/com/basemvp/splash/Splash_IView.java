package com.basemvp.splash;

import android.view.View;

import com.mvp_module.interfaces.MVP_IBaseView;

public interface Splash_IView extends MVP_IBaseView {

    View getActivityView();

    void goToNextActivity();
}
