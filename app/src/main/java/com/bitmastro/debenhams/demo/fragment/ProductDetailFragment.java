package com.bitmastro.debenhams.demo.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.TextView;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.product.ProductColumns;
import com.bitmastro.debenhams.demo.product.ProductCursor;
import com.bitmastro.debenhams.demo.product.ProductSelection;
import com.bitmastro.debenhams.demo.ui.view.KenBurnsView;
import com.bitmastro.debenhams.demo.ui.view.Transition;
import com.squareup.picasso.Picasso;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.FragmentArg;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_product_detail)
public class ProductDetailFragment extends Fragment implements KenBurnsView.TransitionListener {

    private static final int TRANSITIONS_TO_SWITCH = 2;
    @ViewById
    protected TextView nameTextView, brandTextView;
    @ViewById
    protected TextView wasPriceTextView, wasTV;

    @ViewById
    protected TextView nowTV;
    @ViewById
    protected TextView nowPriceTextView;
    @FragmentArg
    long itemId;
    @ViewById(R.id.imageView)
    KenBurnsView imageView;
    private int transitionsCount;
    private int imageIndex;
    private Integer noImg;
    private String imgUrl;

    @AfterViews
    void displayProduct() {
        imageView.pause();
        imageView.setTransitionListener(this);
        getLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                // Change the selection to get a subset of your data
                ProductSelection selection = new ProductSelection();
                selection.id(itemId);
                return new CursorLoader(getActivity(), ProductColumns.CONTENT_URI, ProductColumns.FULL_PROJECTION, selection.sel(), selection.args(), ProductColumns.DEFAULT_ORDER);

            }

            public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
                ProductCursor wrapper = new ProductCursor(cursor);
                wrapper.moveToFirst();
                initView(wrapper);
            }


            public void onLoaderReset(Loader<Cursor> loader) {

            }
        });
    }

    private void initView(ProductCursor wrapper) {
        nameTextView.setText(wrapper.getName());
        brandTextView.setText(wrapper.getBrand());
        final String mingbpWas = wrapper.getMingbpWas();
        if (mingbpWas.equals("0.00")) {
            wasPriceTextView.setVisibility(View.INVISIBLE);
            wasTV.setVisibility(View.INVISIBLE);
            nowTV.setText(getResources().getText(R.string.pounds));
        } else {
            wasPriceTextView.setVisibility(View.VISIBLE);
            wasTV.setVisibility(View.VISIBLE);
            wasPriceTextView.setText(mingbpWas);
            nowTV.setText(getResources().getText(R.string.now_pounds));
        }
        nowPriceTextView.setText(wrapper.getMingbp());
        noImg = wrapper.getNoimg();
        imgUrl = wrapper.getImg();
        Picasso.with(getActivity()).load("http://debenhams.scene7.com/is/image/Debenhams/" + imgUrl + "?hei=440&op_usm=1.1,0.5,0,0").
                into(imageView);
        imageView.resume();
    }


    @Override
    public void onTransitionStart(Transition transition) {

    }

    @Override
    public void onTransitionEnd(Transition transition) {
        transitionsCount++;
        if (transitionsCount == TRANSITIONS_TO_SWITCH) {
            transitionsCount = 0;
            imageIndex++;
            if (imageIndex == noImg) {
                imageIndex = 0;
                Picasso.with(getActivity()).load("http://debenhams.scene7.com/is/image/Debenhams/" + imgUrl + "?hei=440&op_usm=1.1,0.5,0,0").
                        into(imageView);
            } else {
                Picasso.with(getActivity()).load("http://debenhams.scene7.com/is/image/Debenhams/" + imgUrl + "_" + imageIndex + "?hei=440&op_usm=1.1,0.5,0,0").
                        into(imageView);
            }


        }
    }
}
