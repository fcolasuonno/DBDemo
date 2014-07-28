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
@EViewGroup(R.layout.product)
public class ProductView extends RelativeLayout implements ViewHolder {

    @ViewById(R.id.nameTextView)
    protected TextView nameTextView;

    @ViewById(R.id.brandTextView)
    protected TextView brandTextView;

    @ViewById(R.id.wasPriceTextView)
    protected TextView wasPriceTextView;

    @ViewById(R.id.wasTV)
    protected TextView wasTV;

    @ViewById(R.id.nowPriceTextView)
    protected TextView nowPriceTextView;

    @ViewById(R.id.nowTV)
    protected TextView nowTV;

    @ViewById(R.id.imageView)
    protected ImageView imageView;

    int width;

    public ProductView(Context context) {
        super(context);
        Resources r = getResources();
        width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 96, r.getDisplayMetrics());
        int horiz_margin = r.getDimensionPixelSize(R.dimen.activity_horizontal_margin);
        int vert_margin = r.getDimensionPixelSize(R.dimen.activity_vertical_margin);
        setPadding(horiz_margin, vert_margin, horiz_margin, vert_margin);
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
            nowTV.setText(getResources().getText(R.string.pounds));
        } else {
            wasPriceTextView.setVisibility(VISIBLE);
            wasTV.setVisibility(VISIBLE);
            wasPriceTextView.setText(mingbpWas);
            nowTV.setText(getResources().getText(R.string.now_pounds));
        }
        nowPriceTextView.setText(wrapper.getMingbp());
        Picasso.with(getContext()).load("http://debenhams.scene7.com/is/image/Debenhams/" + wrapper.getImg() + "?hei=" + width + "&op_usm=1.1,0.5,0,0").
                placeholder(R.drawable.ic_placeholder).into(imageView);

    }
}