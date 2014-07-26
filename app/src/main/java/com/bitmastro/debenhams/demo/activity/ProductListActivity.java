package com.bitmastro.debenhams.demo.activity;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.ActionBarActivity;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.adapter.ProductAdapter;
import com.bitmastro.debenhams.demo.product.ProductColumns;
import com.bitmastro.debenhams.demo.product.ProductSelection;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentById;

@EActivity(R.layout.activity_product_list)
public class ProductListActivity extends ActionBarActivity {

    @FragmentById
    protected ListFragment product_list;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @AfterViews
    protected void doStuff() {
        getSupportLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                // Change the selection to get a subset of your data
                ProductSelection selection = new ProductSelection();
                return new CursorLoader(ProductListActivity.this, ProductColumns.CONTENT_URI, ProductColumns.FULL_PROJECTION, selection.sel(), selection.args(), ProductColumns.DEFAULT_ORDER);
            }

            public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
                product_list.setListAdapter(new ProductAdapter(ProductListActivity.this, cursor, 0));
            }


            public void onLoaderReset(Loader<Cursor> loader) {

            }
        });

       /* if (findViewById(R.id.product_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ProductListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.product_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.*/
    }

    public void onItemSelected(long id) {
        /*if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putLong(ProductDetailFragment.ARG_ITEM_ID, id);
            ProductDetailFragment fragment = new ProductDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.product_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ProductDetailActivity.class);
            detailIntent.putExtra(ProductDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }*/
    }
}
