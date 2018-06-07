package com.example.knight.lab62;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


//    Widgets used in this application
    EditText sn;
    EditText name;

    Button load;
    Button save;
    Button reset;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Load widget from layout
        sn = findViewById(R.id.sn);
        name = findViewById(R.id.name);
        load = findViewById(R.id.load);
        save = findViewById(R.id.save);
        reset = findViewById(R.id.reset);

//        Get sharedPreference with private mode
        sharedPreferences = getSharedPreferences("student", MODE_PRIVATE);
        editor = sharedPreferences.edit();

//        When load button is clicked
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Get student number data and student name data from shared preference file
                String studentNumber = sharedPreferences.getString("sn", "");
                String studentName = sharedPreferences.getString("name", "");

//                Set TextView text as read data
                sn.setText(studentNumber);
                name.setText(studentName);
            }
        });

//        When save button is clicked
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Get student number data and student name data from widget
                String studentNumber = sn.getText().toString();
                String studentName = name.getText().toString();

//                Put data to sharedPreference file
                editor.putString("sn", studentNumber);
                editor.putString("name", studentName);
                editor.commit();
            }
        });

//        When reset button is clicked, clear EditText view
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sn.setText("");
                name.setText("");
            }
        });
    }
}
