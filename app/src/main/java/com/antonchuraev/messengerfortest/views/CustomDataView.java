package com.antonchuraev.messengerfortest.views;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;

/**
 * Абстрактный класс для view с отображением каких-то данных.
 */
public abstract class CustomDataView<B extends ViewDataBinding, M> extends CustomView<B> implements DataView<M> {

    public CustomDataView(@NonNull Context context) {
        super(context);
    }

    public CustomDataView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomDataView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}