package com.mvp_module.interfaces;


import com.mvp_module.MVP_BaseUtils;

public interface MVP_IBasePresenter<V extends MVP_IBaseView> {

    void onAttach(V mvpView);

    void onDetach();

    void log(String nameClass, String methodName, Exception error);

    MVP_BaseUtils getUtils();

}
