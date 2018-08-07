package com.example.xlhratingbar;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by xingliuhua on 2018/8/7.
 */

public class SimpleRatingView4 extends SimpleRatingView {
    @Override
    public int getStateRes(int posi, int state) {
        int id = R.drawable.ic_star_border_red_400_36dp;
        switch (state) {
            case STATE_NONE:
                id = R.drawable.ic_star_border_red_400_36dp;
                break;
            case STATE_HALF:
                id = R.drawable.ic_star_half_red_400_36dp;
                break;
            case STATE_FULL:
                switch (posi) {
                    case 0:
                        id = R.drawable.ic_star_red_200_36dp;
                        break;
                    case 1:
                        id = R.drawable.ic_star_red_400_36dp;
                        break;
                    case 2:
                        id = R.drawable.ic_star_red_600_36dp;
                        break;
                    case 3:
                        id = R.drawable.ic_star_red_900_36dp;
                        break;
                    case 4:
                        id = R.drawable.ic_star_purple_600_36dp;
                        break;
                    default:
                        id = R.drawable.ic_star_red_400_36dp;
                        break;
                }
                break;
            default:
                break;
        }
        return id;
    }

    @Override
    public ImageView getRatingView(Context context, int numStars, int posi) {
        posi++;
        ImageView imageView = new ImageView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50 * posi, 50 * posi);
        imageView.setLayoutParams(params);
        return imageView;
    }
}
