package com.bitmastro.debenhams.demo.activity;

import android.app.Activity;
import android.content.Intent;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.api.ApiService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_fullscreen)
public class FullscreenActivity extends Activity {

    @AfterViews
    void initSplashScreen() {
        Intent restIntent = new Intent(this, ApiService.class);
        restIntent.putExtra(ApiService.API_TYPE, ApiService.PRODUCT);
        startService(restIntent);
        splashTimeout();
    }

    //@Background(delay=2000)
    @Background(delay = 2000)
    void splashTimeout() {
        // This method will be executed once the timer is over
        // Start your app main activity
        Intent listIntent = new Intent(this, ProductListActivity_.class);
        startActivity(listIntent);

        // close this activity
        finish();
    }
}
