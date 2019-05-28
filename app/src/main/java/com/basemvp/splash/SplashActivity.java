package com.basemvp.splash;

import android.content.Intent;
import android.view.View;

import com.basemvp.R;
import com.basemvp.login.LoginActivity;
import com.mvp_module.MVP_AnimationUtils;
import com.mvp_module.MVP_BaseActivity;

public class SplashActivity extends MVP_BaseActivity implements Splash_IView {


    private Splash_Presenter<Splash_IView> splashPresenter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
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

        splashPresenter = new Splash_Presenter<>(repository());
        splashPresenter.onAttach(this);
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

    @Override
    protected void onResume() {
        super.onResume();

        splashPresenter.restfulApi();

    }

    @Override
    public View getActivityView() {
        return getView();
    }

    @Override
    public void goToNextActivity() {

        Intent intent = LoginActivity.getStartIntent(this);
        startActivity(intent);

        finish();

    }
}
