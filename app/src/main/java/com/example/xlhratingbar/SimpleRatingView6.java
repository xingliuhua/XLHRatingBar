package com.example.xlhratingbar;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by xingliuhua on 2018/8/7.
 */

public class SimpleRatingView6 extends SimpleRatingView {
    @Override
    public int getStateRes(int posi, int state) {
        int id = R.drawable.not_selected;
        switch (state) {
            case STATE_NONE:
                id = R.drawable.not_selected;
                break;
            case STATE_HALF:
                id = R.drawable.selected_half;
                break;
            case STATE_FULL:
                id = R.drawable.selected;
                break;
            default:
                break;
        }
        return id;
    }

    @Override
    public ImageView getRatingView(Context context, int numStars, int posi) {
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = 20;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
