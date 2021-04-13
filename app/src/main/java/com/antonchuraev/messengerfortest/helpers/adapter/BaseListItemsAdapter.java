package com.antonchuraev.messengerfortest.helpers.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.antonchuraev.messengerfortest.views.CustomListItemView;
import com.antonchuraev.messengerfortest.views.ItemType;
import com.antonchuraev.messengerfortest.views.ListItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Базовый класс для адаптеров списков
 * Наследовать от него только если в списке отображаем элементы одного типа
 * В остальных случаях использовать MainItemsAdapter
 */
public abstract class BaseListItemsAdapter<M extends ListItem, V extends CustomListItemView> extends RecyclerView.Adapter<ItemHolder> {

    private static final String TAG = BaseListItemsAdapter.class.toString();
    public DataHandler<M> listener;
    protected List<M> items;

    public BaseListItemsAdapter() {
        items = new ArrayList<>();
    }

    protected abstract V getCustomView(Context context, int viewType);

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(getCustomView(parent.getContext(), viewType));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final M item = getItems().get(position);
        holder.bindItem(item);
        holder.setItemClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return getItems().size();
    }

    protected V getItemView(ItemHolder holder) {
        return (V) holder.getItemView();
    }

    public void setItems(List<M> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addItems(List<M> itemList) {
        Log.d(TAG, "addItems " + itemList.size());
        int startPosition = getItemCount();
        items.addAll(itemList);
        notifyItemRangeChanged(startPosition, itemList.size());
    }

    public void addItems(int position, List<M> itemList) {
        items.addAll(position, itemList);
        notifyItemRangeChanged(position, itemList.size());
    }

    public void addItem(M item) {
        items.add(item);
        notifyItemInserted(items.size() - 1);
    }

    public void addItem(int position, M item) {
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void removeAt(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void remove(@Nullable M item) {
        int pos = findItemPosition(item);
        if (pos != -1) {
            items.remove(pos);
            notifyItemRemoved(pos);
        }
    }

    /**
     * Удалить часть элементов из списка
     *
     * @param positionStart - индекс первого удаляемого элемента
     * @param itemCount     - количество удаляемых элементов
     */
    public void removeRange(int positionStart, int itemCount) {
        if (positionStart > getItemCount() - 1) {
            return;
        }
        if (positionStart + itemCount > getItemCount()) {
            itemCount = getItemCount() - positionStart;
        }
        items.subList(positionStart, positionStart + itemCount).clear();
        notifyItemRangeRemoved(positionStart, itemCount);
    }

    public void removeAll() {
        items.clear();
        notifyDataSetChanged();
    }

    public M getItem(int position) {
        return items.get(position);
    }

    public void swapElements(int pos1, int pos2) {
        Collections.swap(items, pos1, pos2);
        notifyItemMoved(pos1, pos2);
    }

    public int findItemPosition(@Nullable ListItem item) {
        if (item == null) return -1;
        return items.indexOf(item);
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getItemType().getItemTypePosition();
    }

    public ItemType findViewType(int position) {
        if (position < 0) {
            return null;
        }
        if (position >= getItemCount()) {
            return null;
        }
        return ItemType.find(getItemViewType(position));
    }

    public List<M> getItems() {
        return items;
    }

    public void moveItem(int fromPosition, int toPosition) {
        if (fromPosition == toPosition) {
            return;
        }
        if (getItemCount() <= fromPosition || getItemCount() <= toPosition || fromPosition < 0 || toPosition < 0) {
            return;
        }
        M item = items.remove(fromPosition);
        items.add(toPosition, item);
        notifyItemMoved(fromPosition, toPosition);
    }
}
