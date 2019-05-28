package com.basemvp.details;

import com.mvp_module.MVP_BasePresenter;
import com.mvp_module.interfaces.MVP_IBaseRepository;

public class Details_Presenter <V extends Details_IView> extends MVP_BasePresenter<V> {

    public Details_Presenter(MVP_IBaseRepository appDataManager) {
        super(appDataManager);
    }
}
