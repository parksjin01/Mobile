package com.example.knight.lab22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText Url;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Url = (EditText)findViewById(R.id.url);         // Read edit text object from main activity by id
        nextBtn = (Button)findViewById(R.id.btn1);      // Read button object from main activity by id

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myUrl = Url.getText().toString();    // Read url from edit text object
                Intent intent = new Intent(getApplicationContext(), NewActivity.class); // Create intent object to change activity from main activity to new activity
                intent.putExtra("Url", myUrl);        // Put extra data to intent
                startActivity(intent);                      // Change activity with previously declared intent
            }
        });
    }
}
