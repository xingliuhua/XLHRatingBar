package com.example.xlhratingbar;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by xingliuhua on 2018/8/7.
 */

public class SimpleRatingView3 extends SimpleRatingView {


    @Override
    public ImageView getRatingView(Context context, int numStars, int posi) {
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, posi + 1);
        imageView.setLayoutParams(params);
        return imageView;
    }
}
