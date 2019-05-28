package com.basemvp.main;

import com.mvp_module.MVP_BasePresenter;
import com.mvp_module.interfaces.MVP_IBaseRepository;

public class Main_Presenter<V extends Main_IView> extends MVP_BasePresenter<V>
        implements Main_IPresenter<V> {

    public Main_Presenter(MVP_IBaseRepository appDataManager) {
        super(appDataManager);
    }
}
