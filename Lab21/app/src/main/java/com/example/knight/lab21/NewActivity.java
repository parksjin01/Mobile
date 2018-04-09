package com.example.knight.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent passedIntent = getIntent();          // Get intent which is passed from MainActivity

        if (passedIntent != null){                  // If intent is gotten successfully
            String loginName = passedIntent.getStringExtra("loginName");    // Extract name value from intent
            String loginAge = passedIntent.getStringExtra("loginAge");      // Extract age value from intent
            Toast.makeText(getApplication(), "Student info: "+loginName+", "+loginAge, Toast.LENGTH_LONG).show();   // Create Toast message and show
        }

        Button button = (Button)findViewById(R.id.ret); // Read button object from new activity by id
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();                               // Destroy current new activity and return to main activity
            }
        });
    }
}
