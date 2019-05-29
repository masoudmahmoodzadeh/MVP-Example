package com.basemvp.teams;

import com.mvp_module.MVP_BasePresenter;
import com.mvp_module.interfaces.MVP_IBaseRepository;

public class Teams_Presenter<V extends Teams_IView> extends MVP_BasePresenter<V> {

    public Teams_Presenter(MVP_IBaseRepository appDataManager) {
        super(appDataManager);
    }
}
