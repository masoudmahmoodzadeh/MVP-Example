package com.basemvp.list;

import com.mvp_module.MVP_BasePresenter;
import com.mvp_module.interfaces.MVP_IBaseRepository;

public class List_Presenter<V extends List_IView> extends MVP_BasePresenter<V> implements List_IPresenter<V> {

    public List_Presenter(MVP_IBaseRepository appDataManager) {
        super(appDataManager);
    }
}
