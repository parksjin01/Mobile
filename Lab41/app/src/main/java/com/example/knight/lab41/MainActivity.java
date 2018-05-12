package com.example.knight.lab41;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      Create my own view
        MyView view = new MyView(this);
        setContentView(view);
    }

    protected class MyView extends View {

        //      Used class attribute
        float x_coordinate = 0; // X coordinate where touch event occur
        float y_coordinate = 0; // Y coordinate where touch event occur
        Paint pnt = new Paint();// Paint object
        Path path = new Path(); // Path object which is used like array to store touched coordinate

        public MyView(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            pnt.setColor(Color.BLUE);           // Set paint color
            pnt.setStyle(Paint.Style.STROKE);   // Set paint style
            pnt.setStrokeWidth(3);              // Set paint stroke width
            canvas.drawPath(path, pnt);         // Draw path on canvas with paint object
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x_coordinate = event.getX();    // Get X coordinate where touch event occur
            y_coordinate = event.getY();    // Get Y coordinate where touch event occur

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                path.moveTo(x_coordinate, y_coordinate);    // If ACTION_DOWN event occur
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                path.lineTo(x_coordinate, y_coordinate);    // Add line to path object
                invalidate();   // Redrawing canvas
            }
            return true;
        }
    }
}
