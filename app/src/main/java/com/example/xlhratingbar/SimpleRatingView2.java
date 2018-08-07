package com.example.xlhratingbar;

/**
 * Created by xingliuhua on 2018/8/7.
 */

public class SimpleRatingView2 extends SimpleRatingView {
    @Override
    public int getCurrentState(float rating, int numStars, int position) {
        position++;
        float dis = position - rating;
        if (dis <= 0.5) {
            return STATE_FULL;
        }
        return STATE_NONE;
    }
}
