package com.example.xlhratingbar_lib;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by xingliuhua on 2018/8/7.
 */

public interface IRatingView {
    /**
     * get image resource state by posi and state
     *
     * @param posi
     * @param state
     * @return
     */
    int getStateRes(int posi, int state);

    /**
     * @param rating
     * @param numStars
     * @param position from 0
     * @return
     */
    int getCurrentState(float rating, int numStars, int position);

    /**
     * get a ImageView,you can set LinearLayout.LayoutParams for your ImageView
     *
     * @param context
     * @param posi    from 0
     * @return
     */
    ImageView getRatingView(Context context,int numStars, int posi);

    /**
     * not selected
     */
    public static final int STATE_NONE = 0;
    /**
     * select half
     */
    public static final int STATE_HALF = 1;
    /**
     * selected
     */
    public static final int STATE_FULL = 2;

}
