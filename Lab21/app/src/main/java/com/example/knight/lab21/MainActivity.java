package com.example.knight.lab21;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    Class property
    EditText Name;
    EditText Age;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.btn);      // Read Button object from main view by id
        Name = (EditText)findViewById(R.id.edit1);  // Read EditText object from main view by id
        Age = (EditText)findViewById(R.id.edit2);   // Read EditText object from main view by id

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String loginName = Name.getText().toString();   // Get name text from Name object
                String loginAge = Age.getText().toString();     // Get age text from Name object
                Intent intent = new Intent(getApplicationContext(), NewActivity.class); // Create intent to change activity
                intent.putExtra("loginName", loginName);  // Put extra data to intent
                intent.putExtra("loginAge", loginAge);    // Put extra data to intent
                startActivity(intent);                          // Change activity with previously declared intent
            }
        });
    }
}
