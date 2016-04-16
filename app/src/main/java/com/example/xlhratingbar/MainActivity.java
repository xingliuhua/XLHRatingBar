package com.example.xlhratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.xlhratingbar_lib.XLHRatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        XLHRatingBar xlhRatingBar3 = (XLHRatingBar) findViewById(R.id.ratingBar3);
        xlhRatingBar3.setCountSelected(1);
        final TextView tvResult = (TextView) findViewById(R.id.tv_result);
        XLHRatingBar ratingBar = (XLHRatingBar) findViewById(R.id.ratingBar4);
        ratingBar.setCountNum(5);
        ratingBar.setCountSelected(1);
        ratingBar.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(int countSelected) {
                tvResult.setText(countSelected + "");
            }
        });
    }
}
