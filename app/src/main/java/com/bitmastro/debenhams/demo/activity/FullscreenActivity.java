package com.bitmastro.debenhams.demo.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.animation.LinearInterpolator;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.api.ApiService;
import com.bitmastro.debenhams.demo.ui.view.AnimatedPathView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_fullscreen)
public class FullscreenActivity extends Activity {

    public static final int DURATION = 2000;
    @ViewById
    protected AnimatedPathView animatedPathView;

    AnimatorSet bouncer = new AnimatorSet();

    @AfterViews
    void initSplashScreen() {
        animate();

        ValueAnimator anim = ObjectAnimator.ofFloat(animatedPathView, "percentage", 0.0f, 1.0f);
        anim.setDuration(DURATION);
        anim.setInterpolator(new LinearInterpolator());
        ValueAnimator fadeAnim = ObjectAnimator.ofInt(animatedPathView, "stroke", 0, 255);
        fadeAnim.setDuration(DURATION / 4);
        bouncer.play(fadeAnim).after(anim);
        bouncer.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationEnd(Animator animation) {
                nextActivity();
            }
        });
    }

    @Click(R.id.animatedPathView)
    void skip() {
        bouncer.cancel();
    }

    @UiThread
    void animate() {
        bouncer.start();
    }

    public void nextActivity() {
        fetchData();
        Intent listIntent = new Intent(this, ProductListActivity_.class);
        startActivity(listIntent);
        finish();
    }

    @Background
    void fetchData() {
        Intent restIntent = new Intent(this, ApiService.class);
        restIntent.putExtra(ApiService.API_TYPE, ApiService.PRODUCT);
        startService(restIntent);
    }

}
