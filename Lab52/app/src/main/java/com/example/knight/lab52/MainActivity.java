package com.example.knight.lab52;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//  Widgets used in this application
    EditText number;
    Button btn;
    TextView res1;
    TextView res2;
    String numbers = "";
    int multiple = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Get widget from layout
        number = (EditText) findViewById(R.id.number);
        btn = (Button) findViewById(R.id.btn);
        res1 = (TextView) findViewById(R.id.res1);
        res2 = (TextView) findViewById(R.id.res2);

//      Add OnClickEvent listener to button
//      When button is pressed start AsyncTask to calculate factorial
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                new Facto().execute();
            }
        });

    }

    private class Facto extends AsyncTask<Void, Integer, Void> {

//      Nothing to do before start tasking
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

//      Doing task in background
//      For each 500ms call onProgressUpdate method and iterate this n times
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i=Integer.parseInt(number.getText().toString()); i > 0; i--) {
                try {
                    Thread.sleep(500);
                    publishProgress(i);
                } catch (Exception e) {

                }
            }
            return null;
        }

//      Append new integer to number sequence string and calculate multiplication
//      Update TextView which show number of sequence
        @Override
        protected void onProgressUpdate(Integer... values) {
            numbers += " " + String.valueOf(values[0].intValue());
            multiple *= values[0].intValue();
            res1.setText(numbers);
            super.onProgressUpdate(values);
        }

//      When AsyncTask is finished, update TextView which show the result of calculation
        @Override
        protected void onPostExecute(Void aVoid) {
            res2.setText("= "+String.valueOf(multiple));
            super.onPostExecute(aVoid);
        }
    }
}
