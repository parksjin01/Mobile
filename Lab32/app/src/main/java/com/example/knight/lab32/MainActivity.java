package com.example.knight.lab32;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

//  Widgets in the layout
    Button btn;
    EditText edit;
    RadioGroup rg;
    CheckBox c1;
    CheckBox c2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Extracting widget view object from layout
        btn = (Button)findViewById(R.id.btn);
        edit = (EditText)findViewById(R.id.edit);
        rg = (RadioGroup)findViewById(R.id.rg);
        c1 = (CheckBox)findViewById(R.id.c1);
        c2 = (CheckBox)findViewById(R.id.c2);

//      Add btn event listern
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){

//              Create Intent to activate other activity with data received from this activity
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

//              Add user name data in edit widget
                intent.putExtra("name", edit.getText().toString());

//              Get selected radio button id
                int id = rg.getCheckedRadioButtonId();

//              Check which radio button is selected and add user gender data to intent object
                switch(id){
                    case R.id.r1:
                        intent.putExtra("gender", "남");
                        break;
                    case R.id.r2:
                        intent.putExtra("gender", "여");
                        break;
                    default:
                        break;
                }

//              Check each checkbox is selected and add user agreement data to intent object
                String marketing = "";
                if(c1.isChecked())
                    marketing += c1.getText().toString()+" ";
                if(c2.isChecked())
                    marketing += c2.getText().toString();
                intent.putExtra("receive", marketing);

//              Activate other activity
                startActivityForResult(intent, 333);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        edit.setText("");
        rg.clearCheck();
        c1.setChecked(false);
        c2.setChecked(false);
    }
}
