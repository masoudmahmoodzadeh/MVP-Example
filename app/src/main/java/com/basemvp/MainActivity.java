package com.basemvp;

import android.content.Context;
import android.content.Intent;

import com.mvp_module.MVP_AnimationUtils;
import com.mvp_module.MVP_BaseActivity;

public class MainActivity extends MVP_BaseActivity {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MVP_AnimationUtils getAnimationTransition() {
        return null;
    }

    @Override
    public void createActionbar() {

    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void findView() {

    }

    @Override
    public void initView() {

    }

    @Override
    public void setSlideMenu() {

    }

    @Override
    public void onClick() {

    }

    @Override
    public MVP_BaseActivity getBaseActivity() {
        return this;
    }
}
