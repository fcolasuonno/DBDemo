package com.bitmastro.debenhams.demo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.animation.LinearInterpolator;

import com.bitmastro.debenhams.demo.R;
import com.bitmastro.debenhams.demo.ui.view.AnimatedPathView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorListenerAdapter;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;


@SuppressLint("Registered")
@EActivity(R.layout.activity_fullscreen)
public class FullscreenActivity extends Activity {

    public static final int DURATION = 2000;
    //    public static final int DURATION = 4;
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
        MainActivity_.intent(this).start();
        finish();
    }


}
