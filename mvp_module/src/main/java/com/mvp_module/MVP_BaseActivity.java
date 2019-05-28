package com.mvp_module;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.mvp_module.interfaces.MVP_IApp;
import com.mvp_module.interfaces.MVP_IBaseRepository;
import com.mvp_module.interfaces.MVP_IBaseView;


public abstract class MVP_BaseActivity extends AppCompatActivity
        implements MVP_IBaseView, MVP_BaseFragment.Callback, MVP_IApp {

    private final String ERROR_MESSAGE = "Error occured ...";
    private FragmentManager fragmentManager;
    private String uniqueTag = "";


    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    private void setConfiguration() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initPresenter();

        setConfiguration();

        fragmentManager = getSupportFragmentManager();

        setAnimationTransition();

        setContentView(getLayoutId());

        setTag(getClass().getSimpleName().concat("_").concat(String.valueOf(System.currentTimeMillis())));

        createActionbar();

        findView();

        initView();

    }

    @Override
    protected void onResume() {
        super.onResume();

        onClick();

        setSlideMenu();

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    // // // // // IBaseView
    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(String message) {
        if (message != null) {
            showSnackBar(message);
        } else {
            showSnackBar(ERROR_MESSAGE);
        }
    }

    @Override
    public void onError(@StringRes int resId) {
        onError(getString(resId));
    }


    @Override
    public void showMessage(String message) {
        if (message != null) {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, ERROR_MESSAGE, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showMessage(int resId) {

        showMessage(getString(resId));
    }


    @Override
    public void hideKeyboard() {
        try {

            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

        } catch (Exception e) {

            log(getClass().getSimpleName(), provideUtils().getMethodName(), e);
        }

    }

    @Override
    public String getUniqueTag() {
        return uniqueTag;
    }


    @Override
    public void transactionFragment(int viewContainerID, MVP_BaseFragment destinationFragment,
                                    boolean isAddToBackStack) {

        new MVP_FragmentUtils.Builder()
                .setDestinationFragment(destinationFragment)
                .setFragmentManager(provideFragmentManager())
                .setAddToBackStack(isAddToBackStack)
                .setContainerViewID(viewContainerID)
                .create()
                .transaction();

    }


    // // // // // IApp
    @Override
    public boolean isNetworkConnected() {
        return getApplicationController().isNetworkConnected();
    }

    @Override
    public MVP_BaseUtils provideUtils() {
        return getApplicationController().provideUtils();
    }

    @Override
    public int getWidthDevice() {
        return getApplicationController().getWidthDevice();
    }

    @Override
    public int getHeightDevice() {
        return getApplicationController().getHeightDevice();
    }

    @Override
    public LayoutInflater provideLayoutInflater() {
        return getApplicationController().provideLayoutInflater();
    }

    @Override
    public void log(String nameClass, String methodName, Exception error) {

        provideUtils().log(nameClass, methodName, error);

    }

    @Override
    public MVP_AnimationUtils animationUtils() {
        return getApplicationController().animationUtils();
    }


    // abstract methods

    public abstract @LayoutRes
    int getLayoutId();

    public abstract MVP_AnimationUtils getAnimationTransition();

    public abstract void createActionbar();

    public abstract void initPresenter();

    public abstract void findView();

    public abstract void initView();

    public abstract void setSlideMenu();

    public abstract void onClick();

    // others

    public MVP_AppController getApplicationController() {
        return (MVP_AppController) getApplication();
    }

    public MVP_IBaseRepository repository() {

        return getApplicationController();
    }

    public View getView() {

        return ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
    }

    public FragmentManager provideFragmentManager() {
        return fragmentManager;
    }

    private void setAnimationTransition() {

        MVP_AnimationUtils MVVMAnimationUtils = getAnimationTransition();

        if (MVVMAnimationUtils != null)
            overridePendingTransition(MVVMAnimationUtils.getEnterAnimation(), MVVMAnimationUtils.getExitAnimation());

    }

    public void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView
                .findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.white));
        snackbar.show();
    }


    public void setTag(String tag) {

        this.uniqueTag = tag;

    }


}
