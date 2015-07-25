package com.pragatiplusplus.tictactoe.ui.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by brajesh.k on 20/07/15.
 */
public class TTTView extends ImageView {
    private State mCurrentState;
    private static final float DIM = 0.5f;
    private static final float GLOW = 1.0f;
    private Drawable mCrossDrawable;
    private Drawable mCircleDrawable;

    public TTTView(Context context) {
        super(context);
    }

    public TTTView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TTTView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public static enum State {
        EMPTY,
        CROSS,
        CIRCLE
    }

    public void setState(State state) {
        mCurrentState = state;
        switch (state) {
            case EMPTY:
                setState(GLOW, null);
                break;
            case CROSS:
                setState(GLOW, mCrossDrawable);
                break;
            case CIRCLE:
                setState(GLOW, mCircleDrawable);
                break;
            default:
                break;
        }
    }

    public State getState() {
        return mCurrentState;
    }

    private void setState(float alpha, Drawable drawable) {
        setAlpha(alpha);
        setImageDrawable(drawable);
    }

    public void setCircleDrawable(int resId) {
        mCircleDrawable = ContextCompat.getDrawable(getContext(), resId);
    }

    public void setCrossDrawable(int resId) {
        mCrossDrawable = ContextCompat.getDrawable(getContext(), resId);
    }
}
