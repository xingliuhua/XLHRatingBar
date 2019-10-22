package com.example.xlhratingbar_lib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * simple ratingView. you can custom your view by implements IRatingView.
 *
 * Created by xingliuhua on 2018/8/7.
 */

public class SimpleRatingView implements IRatingView {

    ViewGroup mViewGroup;

    @Override
    public void setCurrentState(int state, int position,int starNums) {

        TextView textView = mViewGroup.findViewById(R.id.tv_state);
        ImageView ivStar = mViewGroup.findViewById(R.id.iv_star);
        switch (state) {
            case IRatingView.STATE_NONE:
                ivStar.setImageResource(R.drawable.icon_star_none);
                textView.setText("none");
                break;
            case IRatingView.STATE_HALF:
                ivStar.setImageResource(R.drawable.icon_star_half);

                textView.setText("half");
                break;
            case IRatingView.STATE_FULL:
                ivStar.setImageResource(R.drawable.icon_star_full);

                textView.setText("full");

                break;
        }
    }

    @Override
    public ViewGroup getRatingView(Context context, int position,int starNums) {
        View inflate = View.inflate(context, R.layout.rating, null);
        mViewGroup = (ViewGroup) inflate;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.weight=1;
        mViewGroup.setLayoutParams(layoutParams);
        return mViewGroup;
    }
}
