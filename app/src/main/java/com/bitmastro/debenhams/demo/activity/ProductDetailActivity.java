package com.bitmastro.debenhams.demo.activity;

import android.annotation.SuppressLint;
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
@SuppressLint("Registered")
@EActivity(R.layout.activity_product_detail)
public class ProductDetailActivity extends ActionBarActivity {

    @Extra
    long productId;

    @FragmentById
    ProductDetailFragment product_detail_container;

    @AfterViews
    void init() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ProductDetailFragment fragment = ProductDetailFragment_.builder().itemId(productId).build();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.product_detail_container, fragment)
                .commit();
    }

    @OptionsItem(android.R.id.home)
    public void navigateUp(MenuItem item) {
        NavUtils.navigateUpTo(this, new Intent(this, ProductListActivity_.class));
    }
}
