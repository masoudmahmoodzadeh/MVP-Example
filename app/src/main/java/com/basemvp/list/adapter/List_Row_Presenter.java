package com.basemvp.list.adapter;

import android.support.v7.widget.RecyclerView;

import com.mvp_module.MVP_BasePresenter;
import com.mvp_module.interfaces.MVP_IBaseRepository;

import java.util.List;

public class List_Row_Presenter<V extends List_Row_IView> extends MVP_BasePresenter<V>
        implements List_Row_IPresenter<V> {

    private List<List_Item> listItems;

    public List_Row_Presenter(MVP_IBaseRepository appDataManager, List<List_Item> listItems) {
        super(appDataManager);
        this.listItems = listItems;
    }

    @Override
    public void onBind(RecyclerView.ViewHolder viewHolder, int position) {

        List_Adapter.ListViewHolder listViewHolder = (List_Adapter.ListViewHolder) viewHolder;

        List_Item listItem = listItems.get(position);

        listViewHolder.iv_icon.setBackgroundResource(listItem.getIcon());
        listViewHolder.tv_title.setText(listItem.getTitle().concat(" ").concat(String.valueOf(position)));


    }
}
