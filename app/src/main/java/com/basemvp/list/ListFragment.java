package com.basemvp.list;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.basemvp.R;
import com.basemvp.list.adapter.List_Adapter;
import com.basemvp.list.adapter.List_Item;
import com.mvp_module.MVP_BaseActivity;
import com.mvp_module.MVP_BaseFragment;

import java.util.ArrayList;
import java.util.List;

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

        getBaseActivity().finish();
    }

    @Override
    public MVP_BaseActivity getBaseActivity() {
        return baseActivity;
    }

    private void initRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseActivity(),
                LinearLayoutManager.VERTICAL, false);

        rv_list.setLayoutManager(linearLayoutManager);

        List_Adapter listAdapter = new List_Adapter(this, repository(), createItems());
        rv_list.setAdapter(listAdapter);

    }

    private List<List_Item> createItems() {

        List<List_Item> items = new ArrayList<>();

        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));
        items.add(new List_Item(R.drawable.ic_mvp, "position"));
        items.add(new List_Item(R.drawable.ic_mvvm, "position"));


        return items;
    }
}
