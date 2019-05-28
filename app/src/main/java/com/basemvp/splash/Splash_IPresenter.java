package com.basemvp.splash;

import com.mvp_module.interfaces.MVP_IBasePresenter;

public interface Splash_IPresenter<V extends Splash_IView> extends MVP_IBasePresenter<V> {

    void restfulApi();
}
