package com.example.knight.lab32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Extracting widget view object from layout
        TextView name = (TextView)findViewById(R.id.name);
        TextView gender = (TextView)findViewById(R.id.gender);
        TextView receive = (TextView)findViewById(R.id.receive);
        Button btn_back = (Button)findViewById(R.id.btn_back);

//      Get intent which is transmitted from main acitivity
        Intent intent = getIntent();

//      Extract data from activity and set each data to appropriate TextView widget
        name.setText(intent.getStringExtra("name"));
        gender.setText(intent.getStringExtra("gender"));
        receive.setText(intent.getStringExtra("receive"));

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
