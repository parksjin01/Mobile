package com.example.knight.lab51;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//  Widgets used in this activity
    ImageView img1;
    ImageView img2;
    EditText log;
    Button btn;

//  Handler
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Get widget object from layout
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        log = findViewById(R.id.log);
        btn = findViewById(R.id.btn);

//      Add OnClickEvent listener to button
        btn.setOnClickListener(new View.OnClickListener() {
            @Override

//          When button is clicked
            public void onClick(View v) {

//              Create 2 Dog threads and run
                DogThread dog1 = new DogThread(0);
                dog1.start();

                DogThread dog2 = new DogThread(1);
                dog2.start();
            }
        });
    }

//  Dog thread which determine which image should be shown in image view
//  This is not main thread so it can't change UI directly
    class DogThread extends Thread {
        int dogIndex;       // To identify this thread is for first image view or second image view
        int stateIndex;     // To identify which image should be shown

        ArrayList<Integer> images = new ArrayList<Integer>();   // Array to store 3 images

//      Constructor of this class
        public DogThread(int index) {
            dogIndex = index;                           // Identify image view
            images.add(R.drawable.dog_eating);          // Store image id in array
            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_study);
        }

//      Run method
        @Override
        public void run() {
            stateIndex = 0;                 // Initial image is dog_eating image
            for (int i = 0; i < 9; i++) {   // iterate 9 times
                final String msg = "dog #" + dogIndex + " state: " + stateIndex;    // Create message which designate current image view and dog image state

//              This class is not main class and can't change UI.
//              Request main thread to do UI task
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        log.append(msg + '\n');     // Append created message to EditText view

//                      Change the image in image view according to image view index and image index
                        if (dogIndex == 0) {
                            img1.setImageResource(images.get(stateIndex));
                        } else if (dogIndex == 1) {
                            img2.setImageResource(images.get(stateIndex));
                        }
                    }
                });

//              Wait randomly from 500ms to 3000ms until change image
                try {
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                } catch (Exception e) {
                    e.printStackTrace();
                }

//              Increase image index
                stateIndex = (stateIndex+1)%images.size();

            }
        }
    }

//  Method which create random time to sleep
    public int getRandomTime(int start, int end) {
        return start + (int)(Math.random()*(end - start));
    }
}
