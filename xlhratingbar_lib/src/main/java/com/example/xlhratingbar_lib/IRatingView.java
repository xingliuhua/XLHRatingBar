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
    /**
     * you can change your item style by state and position. eg:color,text size.
     * @param state STATE_NONE,STATE_HALF,STATE_FULL
     * @param position star index. start from 0
     * @param starNums star item number
     */
    void setCurrentState(int state,int position,int starNums);

    /**
     * return you start item view,you can custom item by positon
     * @param context
     * @param position star index. start from 0
     * @param starNums star item number
     * @return
     */
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
