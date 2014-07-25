package com.bitmastro.debenhams.demo.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.bitmastro.debenhams.demo.base.ViewHolder;
import com.bitmastro.debenhams.demo.ui.viewmodel.ProductView_;


public class ProductAdapter extends CursorAdapter {

    public ProductAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return ProductView_.build(context);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view;
        holder.bind(cursor);
    }
}
