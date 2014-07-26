package com.bitmastro.debenhams.demo.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;

import com.bitmastro.debenhams.demo.R;

public class AnimatedPathView extends View {

    Paint mPaint;
    Path[] mPath;
    int mStrokeColor;
    float mStrokeWidth;

    float mProgress = 0f;
    float mPathLength = 0f;


    public AnimatedPathView(Context context) {
        this(context, null);
        init();
    }

    public AnimatedPathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public AnimatedPathView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.AnimatedPathView);
        mStrokeColor = a.getColor(R.styleable.AnimatedPathView_strokeColor, 0xffffffff);
        mStrokeWidth = a.getFloat(R.styleable.AnimatedPathView_strokeWidth, 2.0f);
        a.recycle();

        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mStrokeColor);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(mStrokeWidth);
        mPaint.setAntiAlias(true);

        setPath(Paths.DEBPATH);
    }

    public void setPath(Path[] p) {
        mPath = p;
        for (int i = 0; i < p.length; i++) {
            Path path = p[i];
            PathMeasure measure = new PathMeasure(path, false);
            mPathLength = Math.max(measure.getLength(), mPathLength);
        }
    }

    public void setPercentage(float percentage) {
        if (percentage < 0.0f || percentage > 1.0f)
            throw new IllegalArgumentException("setPercentage not between 0.0f and 1.0f");
        mProgress = percentage;
        invalidate();
    }

    public void setStroke(int percentage) {
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAlpha(percentage);
        invalidate();
    }

    public void transformPathsBy(Matrix m) {

        for (int i = 0; i < mPath.length; i++) {
            Path path = mPath[i];
            path.transform(m);
            PathMeasure measure = new PathMeasure(path, false);
            mPathLength = Math.max(measure.getLength(), mPathLength);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Matrix m = new Matrix();
        if (h > w) {
            m.postScale((float) w / Paths.PATH_SIZE, (float) w / Paths.PATH_SIZE);
            m.postTranslate(0, (h - w) / 2);
        } else {
            m.postScale((float) h / Paths.PATH_SIZE, (float) h / Paths.PATH_SIZE);
            m.postTranslate((w - h) / 2, 0);
        }
        transformPathsBy(m);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        PathEffect pathEffect = new DashPathEffect(new float[]{mPathLength, mPathLength}, (mPathLength - mPathLength * mProgress));
        mPaint.setPathEffect(pathEffect);

        canvas.save();
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        for (int i = 0; i < mPath.length; i++) {
            canvas.drawPath(mPath[i], mPaint);
        }
        canvas.restore();
    }
}