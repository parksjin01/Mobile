package com.example.knight.a03_views_layout;

// Import required package
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    Class property which will be used in event handler
    public EditText edit_name;
    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // inflate main view

        init();
    }

    // Getting object of XML widget by Id
    public void init()
    {
        edit_name = (EditText)findViewById(R.id.edit);      // get EditText object from main view by id
        btn_print = (Button)findViewById(R.id.print);       // get Button object from main view by id
        btn_clear = (Button)findViewById(R.id.clear);       // get Button object from main view by id
        view_print = (TextView)findViewById(R.id.text);     // get TextView object from main view by id
    }

    // If clear button is clicked, this function will called
    public void clearClicked(View v){
        edit_name.setText("");                              // Clear text in EditText widget
        edit_name.setHint("type your name");                // Set placeholder("type your name") by use setHint method in EditText widget
        view_print.setText("Component");                    // Set default text("Component") in TextView widget
    }

    public void printClicked(View v){
        String text = "";
        text = edit_name.getText().toString();              // Get text in EditText widget
        view_print.setText(edit_name.getText());            // Set text which is gotten from EditText in TextView widget
        edit_name.setText("");                              // Clear text in EditText widget
        edit_name.setHint("type your name");                // Set placeholder("type your name") by use setHint method in EditText widget
    }

}
