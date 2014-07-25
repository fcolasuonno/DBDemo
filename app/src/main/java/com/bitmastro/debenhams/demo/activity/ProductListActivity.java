package com.bitmastro.debenhams.demo.activity;

import android.support.v4.app.FragmentActivity;

import com.bitmastro.debenhams.demo.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_product_list)
public class ProductListActivity extends FragmentActivity {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @AfterViews
    protected void doStuff() {


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
