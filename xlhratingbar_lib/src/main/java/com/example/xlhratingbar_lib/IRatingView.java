package com.example.xlhratingbar_lib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by xingliuhua on 2018/8/7.
 */

public interface IRatingView {

    void setCurrentState(int state,int position,int starNums);


    ViewGroup getRatingView(Context context,int position,int starNums);

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
