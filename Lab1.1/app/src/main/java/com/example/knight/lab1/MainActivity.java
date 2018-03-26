package com.example.knight.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    //    Class property which will be used in event handler
    ImageView imageView1;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                 // inflate main view

        imageView1 = (ImageView) findViewById(R.id.image1);     // get ImageView object from main view by id
        imageView2 = (ImageView) findViewById(R.id.image2);     // get ImageView object from main view by id
    }

    public void onButton1Clicked(View v){
        changeImage();                                          // If button is clicked, call changeImage method
    }

    private void changeImage(){
        if(imageView1.getVisibility() == View.INVISIBLE){       // If image in ImageView1 is invisible
            imageView1.setVisibility(View.VISIBLE);             // Change ImageView1 as visible
            imageView2.setVisibility(View.INVISIBLE);           // Change ImageView2 as invisible
        }                                                       // Now image in ImageView1 will be shown

        else if(imageView1.getVisibility() == View.VISIBLE){    // If image in ImageView1 is visible
            imageView1.setVisibility(View.INVISIBLE);           // Change ImageView1 as invisible
            imageView2.setVisibility(View.VISIBLE);             // Change ImageView2 as visible
        }                                                       // Now image in ImageView2 will be shown
    }

}
