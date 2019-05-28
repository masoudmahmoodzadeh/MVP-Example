package com.basemvp.login;

import com.mvp_module.MVP_BasePresenter;
import com.mvp_module.interfaces.MVP_IBaseRepository;

public class Login_Presenter<V extends Login_IView> extends MVP_BasePresenter<V>
        implements Login_IPresenter<V> {

    public Login_Presenter(MVP_IBaseRepository appDataManager) {
        super(appDataManager);
    }

    @Override
    public void server_login(String username, String password) {

        // send your request to server

        getMvpView().onSuccessLogin();

    }
}
