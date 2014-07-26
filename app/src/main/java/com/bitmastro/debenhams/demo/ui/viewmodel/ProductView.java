/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.ui.viewmodel;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.base.ViewHolder;
import com.bitmastro.debenhams.demo.product.ProductCursor;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * ViewModel object for the {@code product}.
 */
@EViewGroup(R.layout.view_product)
public class ProductView extends RelativeLayout implements ViewHolder {
    @ViewById
    protected TextView nameTextView, brandTextView;

    @ViewById
    protected TextView wasPriceTextView, wasTV;

    @ViewById
    protected TextView nowPriceTextView;

    @ViewById
    protected ImageView imageView;

    int width;

    public ProductView(Context context) {
        super(context);
        Resources r = getResources();
        width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 96, r.getDisplayMetrics());
    }

    @Override
    public void bind(Cursor item) {
        //Do stuff with Model class
        ProductCursor wrapper = new ProductCursor(item);
        nameTextView.setText(wrapper.getName());
        brandTextView.setText(wrapper.getBrand());
        final String mingbpWas = wrapper.getMingbpWas();
        if (mingbpWas.equals("0.00")) {
            wasPriceTextView.setVisibility(INVISIBLE);
            wasTV.setVisibility(INVISIBLE);
        } else {
            wasPriceTextView.setVisibility(VISIBLE);
            wasTV.setVisibility(VISIBLE);
            wasPriceTextView.setText(mingbpWas);
        }
        nowPriceTextView.setText(wrapper.getMingbp());
        Picasso.with(getContext()).load("http://debenhams.scene7.com/is/image/Debenhams/" + wrapper.getImg() + "?hei=" + width + "&op_usm=1.1,0.5,0,0").into(imageView);

    }
}