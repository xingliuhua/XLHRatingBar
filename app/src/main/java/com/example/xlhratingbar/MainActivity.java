package com.example.xlhratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        final XLHRatingBar xlhRatingBar = (XLHRatingBar) findViewById(R.id.ratingBar);
        xlhRatingBar.setNumStars(7);
        xlhRatingBar.setRating(5);
        xlhRatingBar.setRatingView(new SimpleRatingView5());
        xlhRatingBar.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(float rating, int numStars) {
                Toast.makeText(getApplicationContext(), "rating:" + rating, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_get_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "rating:" + xlhRatingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
