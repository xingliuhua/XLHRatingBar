package com.example.xlhratingbar;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by xingliuhua on 2018/8/7.
 */

public class SimpleRatingView5 extends SimpleRatingView {

    @Override
    public ImageView getRatingView(Context context, int numStars, int posi) {
        ImageView imageView = new ImageView(context);
        float dis = posi - numStars / 2;
        dis = Math.abs(dis);
        int width = (int) (200 * (1 - dis / 5f));
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, width);
        imageView.setLayoutParams(params);
        return imageView;
    }
}
