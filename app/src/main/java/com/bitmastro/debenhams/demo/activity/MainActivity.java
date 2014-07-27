package com.bitmastro.debenhams.demo.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.ActionBarActivity;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.fragment.CategoryListFragment;
import com.bitmastro.debenhams.demo.fragment.CategoryListFragment_;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

@SuppressLint("Registered")
@EActivity(R.layout.activity_main)
public class MainActivity extends ActionBarActivity {

    @AfterViews
    void init() {
        CategoryListFragment fragment = CategoryListFragment_.builder().build();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.placeholder_container, fragment)
                .commit();
    }


}
