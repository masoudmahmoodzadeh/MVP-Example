package com.basemvp.list.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.basemvp.R;
import com.mvp_module.MVP_BaseAdapter;
import com.mvp_module.interfaces.MVP_IBaseRepository;
import com.mvp_module.interfaces.MVP_IBaseView;

import java.util.List;

public class List_Adapter extends MVP_BaseAdapter implements List_Row_IView {

    private List<List_Item> listItems;

    private List_Row_Presenter<List_Row_IView> listRowPresenter;

    public List_Adapter(MVP_IBaseView mvp_iBaseView, MVP_IBaseRepository iBaseRepository, List<List_Item> listItems) {
        super(mvp_iBaseView, iBaseRepository);

        this.listItems = listItems;
    }

    @Override
    public int getLayoutId() {
        return R.layout.row_list;
    }

    @Override
    public void initPresenter() {

        if (listRowPresenter == null) {
            listRowPresenter = new List_Row_Presenter<>(iBaseRepository , listItems);
            listRowPresenter.onAttach(this);
        }
    }

    @Override
    public BaseViewHolder createViewHolder() {
        return new ListViewHolder(rowView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ListViewHolder listViewHolder = (ListViewHolder) viewHolder;
        listRowPresenter.onBind(listViewHolder, position);
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ListViewHolder extends BaseViewHolder {

        public ImageView iv_icon;
        public TextView tv_title;

        public ListViewHolder(View itemView) {
            super(itemView);

            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
