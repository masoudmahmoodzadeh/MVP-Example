package com.basemvp.login;

import com.mvp_module.interfaces.MVP_IBasePresenter;

public interface Login_IPresenter<V extends Login_IView> extends MVP_IBasePresenter<V> {

    void server_login(String username , String password);
}
