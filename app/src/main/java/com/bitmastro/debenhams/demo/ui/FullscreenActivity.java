package com.bitmastro.debenhams.demo.ui;

import com.bitmastro.debenhams.demo.api.ApiService;
import com.bitmastro.debenhams.demo.api.RestService;
import com.bitmastro.debenhams.demo.ui.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.bitmastro.debenhams.demo.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class FullscreenActivity extends Activity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        final View contentView = findViewById(R.id.fullscreen_content);
        Intent restIntent = new Intent(this, ApiService.class);
        restIntent.putExtra(ApiService.API_TYPE,ApiService.PRODUCT);
        startService(restIntent);
    }
}
