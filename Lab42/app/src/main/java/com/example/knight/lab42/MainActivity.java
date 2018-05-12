package com.example.knight.lab42;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    //  Widgets used in this activity
    Button btn1;
    Button btn2;
    LinearLayout frame1;
    LinearLayout frame2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Get widget object from layout
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        frame1 = (LinearLayout) findViewById(R.id.frame1);
        frame2 = (LinearLayout) findViewById(R.id.frame2);

//      Add event listener to first button
//      Start animation to slide second linear layout
//      Second linear layouts visibility is "GONE" so change it to "Visible"
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translation_left);
                frame2.startAnimation(animation);
                frame2.setVisibility(View.VISIBLE);
            }
        });

//      Add event listener to second button
//      Start animation to slide out second linear layout
//      Second linear layout visibility is "Visible" but first linear layout should be shown
//      So it's visibility should be "GONE"
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translation_right);
                frame2.startAnimation(animation);
                frame2.setVisibility(View.GONE);
            }
        });
    }
}
