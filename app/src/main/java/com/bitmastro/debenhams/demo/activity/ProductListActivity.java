package com.bitmastro.debenhams.demo.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v4.app.ListFragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.fragment.ProductDetailFragment;
import com.bitmastro.debenhams.demo.fragment.ProductDetailFragment_;
import com.bitmastro.debenhams.demo.fragment.ProductListFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.OptionsItem;

@SuppressLint("Registered")
@EActivity(R.layout.activity_product_list)
public class ProductListActivity extends ActionBarActivity implements ProductListFragment.Callbacks {

    @FragmentById
    protected ListFragment product_list;
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
}
