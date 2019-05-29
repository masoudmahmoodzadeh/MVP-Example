package com.mvp_module.interfaces;

import android.support.v7.widget.RecyclerView;

public interface MVP_IAdapterPresenter<V extends MVP_IBaseView> extends MVP_IBasePresenter<V> {

    void onBind(RecyclerView.ViewHolder viewHolder, int position);


}
