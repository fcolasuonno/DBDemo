/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.bitmastro.debenhams.demo.adapter.ProductAdapter;
import com.bitmastro.debenhams.demo.product.ProductColumns;
import com.bitmastro.debenhams.demo.product.ProductSelection;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;

/**
 * A fragment representing a list of products.
 */
@EFragment
public class ProductListFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    @AfterViews
    public void initLoader() {
        getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // Change the selection to get a subset of your data
        ProductSelection selection = new ProductSelection();
        return new CursorLoader(getActivity(), ProductColumns.CONTENT_URI, ProductColumns.FULL_PROJECTION, selection.sel(), selection.args(), ProductColumns.DEFAULT_ORDER);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        setListAdapter(new ProductAdapter(getActivity(), cursor, 0));
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
