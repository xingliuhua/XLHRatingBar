package com.xingliuhua.example.xlhratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.xingliuhua.xlhratingbar.XLHRatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        LinearLayout llContainer = (LinearLayout) findViewById(R.id.ll_container);
        XLHRatingBar xlhRatingBar = new XLHRatingBar(this);
        xlhRatingBar.setNumStars(3);
        xlhRatingBar.setRatingViewClassName("com.xingliuhua.example.xlhratingbar.MyRatingView4");
        xlhRatingBar.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(float rating, int numStars) {
                Log.e("MainActivity", "rating:" + rating);
            }
        });
        llContainer.addView(xlhRatingBar);
    }
}
