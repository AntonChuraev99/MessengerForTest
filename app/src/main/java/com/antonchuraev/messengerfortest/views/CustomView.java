package com.antonchuraev.messengerfortest.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;


public abstract class CustomView<B extends ViewDataBinding> extends FrameLayout {

    protected B binding;

    public CustomView(@NonNull Context context) {
        super(context);
        initBinding();
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initBinding();
    }

    public CustomView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initBinding();
    }

    private void initBinding() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(this.getContext()), getLayoutRes(), this, true);
    }

    @LayoutRes
    protected abstract int getLayoutRes();

}
