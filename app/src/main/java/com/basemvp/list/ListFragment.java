package com.basemvp.list;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.basemvp.R;
import com.mvp_module.MVP_BaseActivity;
import com.mvp_module.MVP_BaseFragment;

public class ListFragment extends MVP_BaseFragment implements List_IView {

    private RecyclerView rv_list;

    @Override
    public int getRootView() {
        return R.layout.fragment_list;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void findView(View view) {
        rv_list = view.findViewById(R.id.rv_list);
    }

    @Override
    public void onClick() {

    }

    @Override
    public void initViews() {

        initRecyclerView();
    }

    @Override
    public void backPressedButton(Fragment fragment) {

    }

    @Override
    public MVP_BaseActivity getBaseActivity() {
        return baseActivity;
    }

    private void initRecyclerView(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseActivity() ,
                LinearLayoutManager.VERTICAL , false);

        rv_list.setLayoutManager(linearLayoutManager);



    }
}
