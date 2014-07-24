/*
 * Generated file. It will be overwritten.
 */
package com.bitmastro.debenhams.demo.fragment;

import android.support.v4.app.ListFragment;

import android.os.Bundle;
import com.bitmastro.debenhams.demo.R;

import java.util.List;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.database.Cursor;
import oak.viewmodel.ViewModelCursorAdapter;
import com.bitmastro.debenhams.demo.product.ProductColumns;
import com.bitmastro.debenhams.demo.product.ProductCursor;
import com.bitmastro.debenhams.demo.product.ProductSelection;

/**
 * A fragment representing a list of products.
 */
public class ProductListFragment extends ListFragment {

    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        // Add arguments to bundle
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ProductListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            // Instantiate arguments
        }
        getLoaderManager().initLoader(0, null, new LoaderCallbacks());
    }
    private class LoaderCallbacks implements LoaderManager.LoaderCallbacks<Cursor> {
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            // Change the selection to get a subset of your data
            ProductSelection selection = new ProductSelection();
            return new CursorLoader(getActivity(), ProductColumns.CONTENT_URI, ProductColumns.FULL_PROJECTION, selection.sel(), selection.args(), ProductColumns.DEFAULT_ORDER);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
            setListAdapter(new ViewModelCursorAdapter(getActivity(), cursor, true, R.layout.view_product));
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    }
}