package com.example.knight.lab33;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Two button object which is in activity_main layout
    Button btn1;
    Button btn2;

    // Two different fragments
    Fragment1 f1;
    Fragment2 f2;

        // When activity is created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get button view objects in layout
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);

        // Fragment
        f1 = new Fragment1();
        f2 = new Fragment2();

        // Add first button event listener
        // This event listener replace f1 with any fragment in R.id.container
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f1).commit();
            }
        });

        // Add first button event listener
        // This event listener replace f1 with any fragment in R.id.container
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f2).commit();
            }
        });
    }
}
