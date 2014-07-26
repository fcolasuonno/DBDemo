package com.bitmastro.debenhams.demo.activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.fragment.ProductDetailFragment;
import com.bitmastro.debenhams.demo.fragment.ProductDetailFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.OptionsItem;


/**
 * An activity representing a single Product detail screen. This
 * activity is only used on handset devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a {@link ProductListActivity}.
 * <p/>
 * This activity is mostly just a 'shell' activity containing nothing
 * more than a {@link ProductDetailFragment}.
 */
@EActivity(R.layout.activity_product_detail)
public class ProductDetailActivity extends ActionBarActivity {

    @Extra
    long productId;

    @FragmentById
    ProductDetailFragment product_detail_container;

    @AfterViews
    void setupActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ProductDetailFragment fragment = ProductDetailFragment_.builder().itemId(productId).build();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.product_detail_container, fragment)
                .commit();
    }
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don't need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
//        if (savedInstanceState == null) {
//            // Create the detail fragment and add it to the activity
//            // using a fragment transaction.
//            Bundle arguments = new Bundle();
//            arguments.putLong(ProductDetailFragment.ARG_ITEM_ID,
//                    getIntent().getLongExtra(ProductDetailFragment.ARG_ITEM_ID, 0));
//            ProductDetailFragment fragment = new ProductDetailFragment();
//            fragment.setArguments(arguments);
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.product_detail_container, fragment)
//                    .commit();
//        }
    }*/

    @OptionsItem(android.R.id.home)
    public void navigateUp(MenuItem item) {
        NavUtils.navigateUpTo(this, new Intent(this, ProductListActivity_.class));
    }
}
