package com.example.knight.lab61;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.CharBuffer;

public class MainActivity extends AppCompatActivity {

//    Widgets used in this application
    EditText editText;
    Button write;
    Button clear;
    Button read;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Find widget object in layout
        editText = findViewById(R.id.txtData);
        write = findViewById(R.id.write);
        clear = findViewById(R.id.clear);
        read = findViewById(R.id.read);
        finish = findViewById(R.id.finish);

//        When write button is clicked
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

//                    Create directory to create file
                    File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "/MyFiles");
                    directory.mkdirs();

//                    Create file at that directory if file doesn't exist and then get output stream
                    File mysdfile = new File(directory, "mysdfile.txt");
                    FileOutputStream fileOutputStream = null;
                    try {
                        fileOutputStream = new FileOutputStream(mysdfile);
                    } catch (FileNotFoundException e1) {
                        mysdfile.createNewFile();
                        fileOutputStream = new FileOutputStream(mysdfile);
                    }

//                    Write data which is in editText to txt file in external storage and close stream
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    outputStreamWriter.write(editText.getText().toString());
                    outputStreamWriter.close();

//                    Show toast message
                    Toast.makeText(getApplicationContext(), "Done writing SD \"mysdfile.txt\"", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//        Clear EditText widget
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });

//        When read button is clicked
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

//                    Create directory to create file
                    File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "/MyFiles");
                    directory.mkdirs();

//                    Get file at that directory and then get input stream
                    File mysdfile = new File(directory, "mysdfile.txt");
                    FileInputStream fileInputStream = null;
                    fileInputStream = new FileInputStream(mysdfile);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    String str = "";
                    StringBuffer stringBuffer = new StringBuffer();

//                    Read all data in file
                    while ((str = bufferedReader.readLine()) != null) {
                        stringBuffer.append(str);
                    }

//                    Close stream and set text in EditText widget
                    inputStreamReader.close();
                    editText.setText(stringBuffer.toString());

//                    Show toast message
                    Toast.makeText(getApplicationContext(), "Done reading SD \"mysdfile.txt\"", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

//        When finish button is clicked, just terminate application
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
