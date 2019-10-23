package com.example.xlhratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.xlhratingbar_lib.XLHRatingBar;

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
        xlhRatingBar.setRatingViewClassName("com.example.xlhratingbar.MyRatingView4");
        xlhRatingBar.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(float rating, int numStars) {
                Log.e("MainActivity", "rating:" + rating);
            }
        });
        llContainer.addView(xlhRatingBar);
    }
}
