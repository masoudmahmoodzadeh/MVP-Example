package com.basemvp.details;

import android.view.View;

import com.basemvp.R;
import com.mvp_module.MVP_BaseDialog;

public class DetailsDialog extends MVP_BaseDialog {

    @Override
    public int getRootView() {
        return R.layout.dialog_details;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void findView(View view) {

    }

    @Override
    public void onClick() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void backPressed() {

        dismissDialog(getClass().getSimpleName());
    }
}
