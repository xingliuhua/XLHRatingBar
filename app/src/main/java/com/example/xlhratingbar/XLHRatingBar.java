package com.example.xlhratingbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * 星级评分
 *
 * @author xingliuhua
 */
public class XLHRatingBar extends LinearLayout {
    private int countNum;// 共有几个星星
    private int countSelected;//当前选中了几个星星
    private int stateResId;//不同选择状态对应图标
    private float widthAndHeight;//单个星星的大小
    private float dividerWidth;//星星间距
    private boolean canEdit;//可以点击选择
    private boolean differentSize;//不同大小，只有总数为奇数时有效

    public XLHRatingBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.XlHRatingBar);
        countNum = typedArray.getInt(R.styleable.XlHRatingBar_starCount, 5);
        countSelected = typedArray.getInt(R.styleable.XlHRatingBar_countSelected, 0);
        canEdit = typedArray.getBoolean(R.styleable.XlHRatingBar_canEdit, false);
        differentSize = typedArray.getBoolean(R.styleable.XlHRatingBar_differentSize, false);
        widthAndHeight = typedArray.getDimension(
                R.styleable.XlHRatingBar_widthAndHeight,
                UnitUtil.dp2Px(context, 0));
        dividerWidth = typedArray.getDimension(
                R.styleable.XlHRatingBar_dividerWidth,
                UnitUtil.dp2Px(context, 0));
        stateResId = typedArray.getResourceId(
                R.styleable.XlHRatingBar_stateResId, -1);
        initView();
    }

    public int getCountNum() {
        return countNum;
    }

    public void setCountNum(int countNum) {
        this.countNum = countNum;
        initView();
    }

    public int getCountSelected() {
        return countSelected;
    }

    public void setCountSelected(int countSelected) {
        if (countSelected > countNum) {
            return;
        }
        this.countSelected = countSelected;
        initView();
    }


    private void initView() {
        removeAllViews();
        for (int i = 0; i < countNum; i++) {
            CheckBox cb = new CheckBox(getContext());
            LayoutParams layoutParams;
            if (widthAndHeight == 0) {
                layoutParams = new LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            } else {
                layoutParams = new LayoutParams(
                        (int) widthAndHeight, (int) widthAndHeight);
            }
            if (differentSize && countNum % 2 != 0) {
                Log.e("xxx", layoutParams.width + "");
                int index = i;
                if (index > countNum / 2) {
                    index = countNum - 1 - index;
                }
                float scale = (index + 1) / (float) (countNum / 2 + 1);
                layoutParams.width = (int) (layoutParams.width * scale);
                layoutParams.height = layoutParams.width;
            }
            layoutParams.gravity = Gravity.CENTER_VERTICAL;
            if (i != 0 && i != countNum - 1) {
                layoutParams.leftMargin = (int) dividerWidth;
                layoutParams.rightMargin = (int) dividerWidth;
            } else if (i == 0) {
                layoutParams.rightMargin = (int) dividerWidth;
            } else if (i == countNum - 1) {
                layoutParams.leftMargin = (int) dividerWidth;
            }
            addView(cb, layoutParams);
            cb.setButtonDrawable(new ColorDrawable(getResources().getColor(android.R.color.transparent)));
            cb.setBackgroundResource(stateResId);
            if (i + 1 <= countSelected) {
                cb.setChecked(true);
            }
            cb.setEnabled(canEdit);
            cb.setOnClickListener(new MyClickListener(i));
        }

    }

    private class MyClickListener implements OnClickListener {
        int position;

        public MyClickListener(int position) {
            super();
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            countSelected = position + 1;

            for (int i = 0; i < countNum; i++) {
                CheckBox cb = (CheckBox) getChildAt(i);

                if (i <= position) {
                    cb.setChecked(true);
                } else if (i > position) {
                    cb.setChecked(false);
                }
            }
            if (mOnRatingChangeListener != null) {
                mOnRatingChangeListener.onChange(countSelected);
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
        /**
         * ratingBar选中状态发生改变
         *
         * @param countSelected 当前选中的个数
         */
        void onChange(int countSelected);
    }
}
