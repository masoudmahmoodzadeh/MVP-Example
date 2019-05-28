package com.mvp_module;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp_module.interfaces.MVP_IApp;
import com.mvp_module.interfaces.MVP_IBackPressedFragment;
import com.mvp_module.interfaces.MVP_IBaseRepository;
import com.mvp_module.interfaces.MVP_IBaseView;

/**
 * Created by Masoud pc on 8/5/2018.
 */
public abstract class MVP_BaseFragment extends Fragment
        implements MVP_IBaseView, MVP_IApp, MVP_IBackPressedFragment {

    protected MVP_BaseActivity baseActivity;
    private View rootView;
    public boolean isBackPressed = false;
    private String uniqueTag = "";
    private MVP_BaseFragment topFragment;

    public MVP_BaseFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(getRootView(), container, false);

        return rootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findView(view);

        initPresenter();


        initViews();

    }

    @Override
    public void onResume() {
        super.onResume();

        onClick();

        buttonPressed();

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MVP_BaseActivity) {
            MVP_BaseActivity activity = (MVP_BaseActivity) context;
            this.baseActivity = activity;
            activity.onFragmentAttached();
        }
    }

    // // // // // IBaseView

    @Override
    public void showLoading() {

        if (baseActivity != null)
            baseActivity.showLoading();
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(int resId) {
        if (baseActivity != null) {
            baseActivity.onError(resId);
        }
    }

    @Override
    public void onError(String message) {
        if (baseActivity != null) {
            baseActivity.onError(message);
        }
    }

    @Override
    public void showMessage(String message) {
        if (baseActivity != null) {
            baseActivity.showMessage(message);
        }
    }

    @Override
    public void showMessage(int resId) {
        if (baseActivity != null) {
            baseActivity.showMessage(resId);
        }
    }

    public void showSnackBar(String message) {

        baseActivity.showSnackBar(message);
    }

    @Override
    public void onDetach() {
        baseActivity = null;
        super.onDetach();
    }

    @Override
    public void hideKeyboard() {
        if (baseActivity != null) {
            baseActivity.hideKeyboard();
        }
    }


    // // // // // IApp
    @Override
    public boolean isNetworkConnected() {
        if (baseActivity != null) {
            return baseActivity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public MVP_BaseUtils provideUtils() {
        return getBaseActivity().provideUtils();
    }

    @Override
    public int getWidthDevice() {

        return getBaseActivity().getWidthDevice();
    }

    @Override
    public int getHeightDevice() {

        return getBaseActivity().getHeightDevice();

    }

    @Override
    public LayoutInflater provideLayoutInflater() {
        return getBaseActivity().provideLayoutInflater();
    }

    @Override
    public void log(String nameClass, String methodName, Exception error) {

        getBaseActivity().log(nameClass, methodName, error);
    }

    @Override
    public MVP_AnimationUtils animationUtils() {
        return getBaseActivity().animationUtils();
    }

    // // // // // abstract methods

    public abstract int getRootView();

    public abstract void initPresenter();

    public abstract void findView(View view);

    public abstract void onClick();

    public abstract void initViews();

    // // // // // others

    public MVP_IBaseRepository repository() {

        return baseActivity.repository();
    }

    public FragmentManager provideFragmentManager() {

        return baseActivity.provideFragmentManager();

    }

    private void buttonPressed() {

        try {

            if (getView() != null /*&& iBackPressed != null*/) {

                getView().setFocusableInTouchMode(true);
                getView().requestFocus();
                getView().setOnKeyListener(new View.OnKeyListener() {

                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {

                        if (event.getAction() == KeyEvent.ACTION_DOWN)

                            if (keyCode == KeyEvent.KEYCODE_BACK) {

                                MVP_BaseFragment mvp_baseFragment = manageBackButton();
                                backPressedButton(mvp_baseFragment);

                                return true;
                            }

                        return false;
                    }
                });


            }


        } catch (Exception e) {


            log(getClass().getSimpleName(), getBaseActivity().getApplicationController().provideUtils().getMethodName(), e);
        }
    }

    public View getFragmentView() {

        return rootView;
    }

    public interface Callback {

        void onFragmentAttached();

        void onFragmentDetached(String tag);

        void transactionFragment(int viewContainerID, MVP_BaseFragment destinationFragment,
                                 boolean isAddToBackStack);


    }


    public void transactionFragment(int viewContainerID, MVP_BaseFragment destinationFragment,
                                    boolean isAddToBackStack) {

        getBaseActivity().transactionFragment(viewContainerID, destinationFragment, isAddToBackStack);

    }



    public MVP_BaseFragment manageBackButton() {

        if (provideFragmentManager().getBackStackEntryCount() > 1) {

            FragmentManager.BackStackEntry backStackEntry = provideFragmentManager().getBackStackEntryAt(provideFragmentManager().getBackStackEntryCount() - 2);
            topFragment = (MVP_BaseFragment) provideFragmentManager().findFragmentByTag(backStackEntry.getName());
            topFragment.isBackPressed = true;


        }


        return topFragment;
    }

    public MVP_BaseFragment getTopFragment() {
        return topFragment;
    }

    public MVP_BaseFragment getCurrentFragment() {

        MVP_BaseFragment currentFragment = null;

        if (provideFragmentManager().getBackStackEntryCount() > 0) {

            FragmentManager.BackStackEntry backStackEntry = provideFragmentManager().getBackStackEntryAt(provideFragmentManager().getBackStackEntryCount() - 1);
            currentFragment = (MVP_BaseFragment) provideFragmentManager().findFragmentByTag(backStackEntry.getName());

            setUniqueTag(backStackEntry.getName());
        }

        return currentFragment;
    }


    public String getUniqueTag() {

        if (TextUtils.isEmpty(uniqueTag))
            getCurrentFragment();

        return uniqueTag;
    }

    public void setUniqueTag(String tag) {
        this.uniqueTag = tag;
    }




}
