package com.bitmastro.debenhams.demo.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.NavUtils;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;

import com.bitmastro.debenhams.demo.DebenhamsProvider;
import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.fragment.ProductDetailFragment;
import com.bitmastro.debenhams.demo.fragment.ProductDetailFragment_;
import com.bitmastro.debenhams.demo.fragment.ProductListFragment;
import com.bitmastro.debenhams.demo.product.ProductColumns;
import com.bitmastro.debenhams.demo.product.ProductSelection;
import com.bitmastro.debenhams.demo.ui.view.MultiSpinner;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import java.util.ArrayList;

@SuppressLint("Registered")
@EActivity(R.layout.activity_product_list)
@OptionsMenu(R.menu.main)
public class ProductListActivity extends ActionBarActivity implements ProductListFragment.Callbacks {

    @FragmentById
    protected ProductListFragment product_list;
    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @AfterViews
    protected void init() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        if (findViewById(R.id.product_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts. If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ProductListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.product_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    public void onItemSelected(long id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            ProductDetailFragment fragment = ProductDetailFragment_.builder().itemId(id).build();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.product_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            ProductDetailActivity_.intent(this).productId(id).start();
        }
    }

    @OptionsItem(android.R.id.home)
    public void navigateUp(MenuItem item) {
        NavUtils.navigateUpTo(this, new Intent(this, MainActivity_.class));
    }

    @OptionsItem(R.id.action_filter)
    public void filter(MenuItem item) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view = getLayoutInflater().inflate(R.layout.filter_dialog, null);
        final MultiSpinner spinner = (MultiSpinner) view.findViewById(R.id.spinner);
        final ProductSelection selection = new ProductSelection();
        getSupportLoaderManager().initLoader(0, null, new LoaderManager.LoaderCallbacks<Cursor>() {
            @Override
            public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
                // Change the selection to get a subset of your data
                ProductSelection selection = new ProductSelection();
                return new CursorLoader(ProductListActivity.this, DebenhamsProvider.groupBy(ProductColumns.CONTENT_URI, ProductColumns.BRAND), new String[]{ProductColumns._ID, ProductColumns.BRAND, "count(*) AS _count"}, selection.sel(), selection.args(), ProductColumns.BRAND);
            }

            @Override
            public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
                final ArrayList<String> mArrayList = new ArrayList<String>();
                for (data.moveToFirst(); !data.isAfterLast(); data.moveToNext()) {
                    // The Cursor is now set to the right position
                    mArrayList.add(data.getString(1));//,data.getInt(2)));
                }
                spinner.setItems(mArrayList, "All", new MultiSpinner.MultiSpinnerListener() {
                    @Override
                    public void onItemsSelected(boolean[] selected) {
                        boolean firstOr = true;
                        for (int i = 0; i < selected.length; i++) {
                            boolean b = selected[i];
                            if (b) {
                                if (firstOr) {
                                    firstOr = false;
                                    selection.brand(mArrayList.get(i));
                                } else {
                                    selection.or().brand(mArrayList.get(i));
                                }
                            }
                        }
                    }
                });
            }

            @Override
            public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {

            }
        });

        builder.setTitle(getResources().getString(R.string.action_filter)).setCancelable(true)
                .setView(view).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                product_list.setFilter(selection);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // cancel the alert box and put a Toast to the user
                dialog.cancel();
            }
        });

        builder.show();
    }
}
