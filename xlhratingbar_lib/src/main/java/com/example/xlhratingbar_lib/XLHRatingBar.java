package com.example.xlhratingbar_lib;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * 星级评分
 *
 * @author xingliuhua
 */
public class XLHRatingBar extends LinearLayout {
    private int mNumStars;// 共有几个星星
    private float mRating;
    private IRatingView mIRatingView;

    public XLHRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.XlHRatingBar);
        mNumStars = typedArray.getInt(R.styleable.XlHRatingBar_numStars, 5);
        mRating = typedArray.getFloat(R.styleable.XlHRatingBar_rating, 0f);
        String ratingViewClassName = typedArray.getString(R.styleable.XlHRatingBar_ratingViewClass);
        try {
            Class<?> netErrorClass = Class.forName(ratingViewClassName);
            mIRatingView = (IRatingView) netErrorClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        initView();
    }

    public void setRatingView(IRatingView ratingView) {
        this.mIRatingView = ratingView;
        initView();
    }

    public int getNumStars() {
        return mNumStars;
    }

    public void setNumStars(int numStars) {
        this.mNumStars = numStars;
        initView();
    }

    public float getRating() {
        return mRating;
    }

    public void setRating(float rating) {
        if (rating > mNumStars) {
            return;
        }
        this.mRating = rating;
        initView();
    }


    private void initView() {
        removeAllViews();
        if (mIRatingView == null) {
            return;
        }
        for (int i = 0; i < mNumStars; i++) {
            ImageView ratingView = mIRatingView.getRatingView(getContext(), mNumStars, i);
            int resid = mIRatingView.getStateRes(i, mIRatingView.getCurrentState(mRating, mNumStars, i));
            if (resid != -1) {
                ratingView.setImageResource(resid);
            }
            addView(ratingView);

            final int finalI = i + 1;
            ratingView.setOnTouchListener(new OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (!isEnabled()) {
                        return false;
                    }
                    if (event.getAction() != MotionEvent.ACTION_UP) {
                        return true;
                    }
                    if (event.getX() < v.getWidth() / 2f) {
                        mRating = finalI - 0.5f;
                    } else {
                        mRating = finalI;
                    }
                    resetRatingViewRes();
                    if (mOnRatingChangeListener != null) {
                        mOnRatingChangeListener.onChange(mRating, mNumStars);
                    }
                    return true;
                }
            });
        }

    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
    }

    private void resetRatingViewRes() {
        for (int i = 0; i < mNumStars; i++) {
            ImageView imageView = (ImageView) getChildAt(i);
            int resid = mIRatingView.getStateRes(i, mIRatingView.getCurrentState(mRating, mNumStars, i));
            if (resid != -1) {
                imageView.setImageResource(resid);
            }
        }
    }

    private OnRatingChangeListener mOnRatingChangeListener;

    public OnRatingChangeListener getOnRatingChangeListener() {
        return mOnRatingChangeListener;
    }

    public void setOnRatingChangeListener(OnRatingChangeListener onRatingChangeListener) {
        mOnRatingChangeListener = onRatingChangeListener;
    }

    public interface OnRatingChangeListener {

        void onChange(float rating, int numStars);
    }
}
