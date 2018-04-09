package com.example.knight.lab22;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textView = (TextView)findViewById(R.id.txt);        // Read TextView object from new view by id
        goBtn = (Button)findViewById(R.id.btn1);            // Read Button object from new view by id
        backBtn = (Button)findViewById(R.id.btn2);          // Read Button object from new view by id

        final Intent passedIntent = getIntent();                            // Get intent which is passed from MainActivity Add final keyword to use intent instance in class
        final String passedUrl = passedIntent.getStringExtra("Url"); // Extract url string from intent
        textView.setText(passedUrl);                                       // Set TextView text as extracted url

        goBtn.setOnClickListener(new View.OnClickListener() {              // Add onclick event handler to go Button
            @Override
            public void onClick(View view) {
                if (passedIntent != null){                  // If intent is gotten successfully
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl)); // Create implicit intent to handle url
                    startActivity(intent);                  // Change activity from new activity to appropriate activity for handle url
                }else {
                    Toast.makeText(getApplication(), "주소를 다시 입력해주세요", Toast.LENGTH_LONG).show();    // Create toast message to designate url edit text field is blank
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {             // Add onclick event handler to bacl Button
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplication(), "뒤로가기버튼을눌렀습니다.", Toast.LENGTH_LONG).show();        // Create toast message to designate back button is clicked
                finish();                                                   // Destroy current new activity and return to main activity
            }
        });
    }
}
