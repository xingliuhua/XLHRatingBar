package com.example.xlhratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

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
        XLHRatingBar xlhRatingBar4 = (XLHRatingBar) findViewById(R.id.ratingBar4);
        xlhRatingBar4.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(int countSelected) {
                tvResult.setText(countSelected + "");
            }
        });
    }
}
