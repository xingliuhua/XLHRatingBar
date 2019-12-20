package com.xingliuhua.example.xlhratingbar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xingliuhua.xlhratingbar.IRatingView;

/**
 * Created by xingliuhua on 2018/8/7.
 */

public class MyRatingView2 implements IRatingView {

    ViewGroup mViewGroup;

    @Override
    public void setCurrentState(int state, int position, int starNums) {

        ImageView ivStar = mViewGroup.findViewById(com.xingliuhua.xlhratingbar.R.id.iv_star);
        switch (state) {
            case IRatingView.STATE_NONE:
                ivStar.setImageResource(com.xingliuhua.xlhratingbar.R.drawable.icon_star_none);
                break;
            case IRatingView.STATE_HALF:
            case IRatingView.STATE_FULL:
                ivStar.setImageResource(com.xingliuhua.xlhratingbar.R.drawable.icon_star_full);

                break;
        }
    }

    @Override
    public ViewGroup getRatingView(Context context, int position, int starNums) {
        View inflate = View.inflate(context, R.layout.my_rating2, null);
        mViewGroup = (ViewGroup) inflate;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.width = 20 + 30 * (position + 1);
        layoutParams.height = layoutParams.width;
        mViewGroup.setLayoutParams(layoutParams);
        return mViewGroup;
    }
}
