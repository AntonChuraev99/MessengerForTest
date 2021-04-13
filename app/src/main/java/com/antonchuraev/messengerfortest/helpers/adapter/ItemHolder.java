package com.antonchuraev.messengerfortest.helpers.adapter;

import android.view.View;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.antonchuraev.messengerfortest.views.CustomListItemView;
import com.antonchuraev.messengerfortest.views.ListItem;

/**
 * Общий ViewHolder для всех элементов, использующихся в приложении
 */
public class ItemHolder<B extends ViewDataBinding, M extends ListItem, V extends CustomListItemView<B, M>> extends RecyclerView.ViewHolder {

    protected V customListItemView;
    protected M model;

    public ItemHolder(V customListItemView) {
        super(customListItemView);
        this.customListItemView = customListItemView;
    }

    public void bindItem(M model) {
        this.model = model;
        customListItemView.setData(model);
    }

    public void setItemClickListener(DataHandler<M> listener) {
        customListItemView.setOnClickListener(v -> listener.invoke(model) );
    }

    public V getItemView() {
        return customListItemView;
    }
}
