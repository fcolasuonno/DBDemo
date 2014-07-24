/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.ui.viewmodel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.database.Cursor;
import com.bitmastro.debenhams.demo.product.ProductCursor;

import com.bitmastro.debenhams.demo.R;
import oak.viewmodel.ViewModel;

/**
 * ViewModel object for the {@code product}.
 */
public class ProductView extends RelativeLayout implements ViewModel<Cursor>{
   TextView tv;

   public ProductView(Context context) {
        super(context);
    }

    public ProductView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProductView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tv = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void populate(Cursor item) {
        //Do stuff with Model class
        ProductCursor wrapper = new ProductCursor(item);
    }
}