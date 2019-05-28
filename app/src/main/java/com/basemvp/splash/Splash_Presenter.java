package com.basemvp.splash;

import com.mvp_module.MVP_BasePresenter;
import com.mvp_module.interfaces.MVP_IBaseRepository;

public class Splash_Presenter<V extends Splash_IView> extends MVP_BasePresenter<V>
        implements Splash_IPresenter<V> {

    public Splash_Presenter(MVP_IBaseRepository appDataManager) {
        super(appDataManager);
    }

    @Override
    public void restfulApi() {

        // send your request to server

        getMvpView().getActivityView().postDelayed(new Runnable() {
            @Override
            public void run() {

                getMvpView().goToNextActivity();

            }
        }, 2000);
    }
}
