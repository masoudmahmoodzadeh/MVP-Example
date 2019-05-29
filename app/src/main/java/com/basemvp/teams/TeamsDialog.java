package com.basemvp.teams;

import android.view.View;

import com.basemvp.R;
import com.mvp_module.MVP_BaseBottomSheet;

public class TeamsDialog extends MVP_BaseBottomSheet {

    @Override
    public int getRootView() {
        return R.layout.dialog_teams;
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
