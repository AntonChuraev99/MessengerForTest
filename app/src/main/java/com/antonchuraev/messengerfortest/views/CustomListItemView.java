package com.antonchuraev.messengerfortest.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

/**
 * Абстрактный класс для view, отображаемых в списках
 */
public abstract class CustomListItemView<B extends ViewDataBinding, M extends ListItem> extends CustomDataView<B, M> {

    public CustomListItemView(@NonNull Context context) {
        super(context);
    }

    public CustomListItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomListItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
