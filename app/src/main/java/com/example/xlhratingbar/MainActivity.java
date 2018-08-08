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
        XLHRatingBar xlhRatingBar3 = (XLHRatingBar) findViewById(R.id.ratingBar3);
        xlhRatingBar3.setEnabled(false);

        final XLHRatingBar xlhRatingBar5 = (XLHRatingBar) findViewById(R.id.ratingBar5);
        xlhRatingBar5.setNumStars(7);
        xlhRatingBar5.setRating(3);
        xlhRatingBar5.setRatingView(new SimpleRatingView5());
        xlhRatingBar5.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
            @Override
            public void onChange(float rating, int numStars) {
                Toast.makeText(getApplicationContext(), "rating:" + rating, Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_get_rating).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "rating:" + xlhRatingBar5.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
