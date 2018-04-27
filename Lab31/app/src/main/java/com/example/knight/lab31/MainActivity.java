package com.example.knight.lab31;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Widgets in the layout
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//      Extracting widget view object from layout
        btn = (Button)findViewById(R.id.btn);
        registerForContextMenu(btn);
    }

//  When menu is created and callback method is called
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);

//      Set context menu title as Button Menu
        menu.setHeaderTitle("Button Menu");

//      Add three menu item which designate color of text as red, green blue
        MenuItem menu1 = menu.add(0, 0, 0, "Red");
        MenuItem menu2 = menu.add(0, 1, 1, "Green");
        MenuItem menu3 = menu.add(0, 2, 2, "Blue");
    }

//  If menu item is selected and callback method is called
    public boolean onContextItemSelected(MenuItem item){

//      Get item id which is selected by the user
        int itemId = item.getItemId();

//      Check which menu item is selected by using switch and change text color
        switch (itemId){
            case 0:
                btn.setTextColor(Color.RED);
                break;
            case 1:
                btn.setTextColor(Color.GREEN);
                break;
            case 2:
                btn.setTextColor(Color.BLUE);
                break;
            default:
                break;
        }

        return true;
    }
}
