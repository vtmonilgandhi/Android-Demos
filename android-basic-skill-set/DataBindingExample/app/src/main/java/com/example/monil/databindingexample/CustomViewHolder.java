package com.example.monil.databindingexample;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by Volansys on 9/2/18.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding mViewDataBinding;

    public CustomViewHolder( ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());

        mViewDataBinding = viewDataBinding;
        mViewDataBinding.executePendingBindings();
    }

    public ViewDataBinding getViewDataBinding() {
        return mViewDataBinding;
    }
}