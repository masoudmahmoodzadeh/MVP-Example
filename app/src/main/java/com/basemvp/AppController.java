package com.basemvp;

import com.mvp_module.MVP_AppController;

public class AppController extends MVP_AppController {

    @Override
    public boolean isNetworkConnected() {
        return true;
    }


}
