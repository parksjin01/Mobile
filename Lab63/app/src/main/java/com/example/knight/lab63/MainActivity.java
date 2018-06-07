package com.example.knight.lab63;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

//    Widgets used in this application
    EditText sn;
    EditText name;
    Button add;
    Button delete;
    ListView listView;
    MySQLiteOpenHelper helper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Find widget object from layout
        sn = findViewById(R.id.sn);
        name = findViewById(R.id.name);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        listView = findViewById(R.id.listView);
        helper = new MySQLiteOpenHelper(this, "school.db", null, 1);

//        If student data is exist in database before addition, check it and show it
        select();

//        When add button is clicked
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Check if both student number and name is given
//                If one of them is not given, show toast message
                if (sn.getText().toString().compareTo("") == 0 || name.getText().toString().compareTo("") == 0)
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_LONG).show();

//                Else
                else {

//                    Put student number and name in to content value object
                    ContentValues contentValues = new ContentValues();

                    contentValues.put("name", name.getText().toString());
                    contentValues.put("sn", sn.getText().toString());

//                    get Writable Database object and insert content value object
                    db = helper.getWritableDatabase();
                    db.insert("student", null, contentValues);

//                    After insertion check existing student data in DB and show it in list view
                    select();
                }
            }
        });

//        When delete button is clicked
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Check if name is given
//                If name is not given, show toast message to type it
                if (name.getText().toString().compareTo("") == 0)
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_LONG).show();

//                Else
                else {

//                    Get writable database object and delete the date which name is corresponding to given one
                    db = helper.getWritableDatabase();
                    db.delete("student", "name=?", new String[]{name.getText().toString()});

//                    After deletion check existing student data in DB and show it in list view
                    select();
                }
            }
        });
    }

//    Check existing sutdent data in DB and show it in list view
    public void select() {

//        Get readable database
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null, null, null, null, null);
        String []student = new String[c.getCount()];

        int idx = 0;

//        Retreiving data with using cursor and save it to string array
        while (c.moveToNext()) {
            student[idx] = c.getString(c.getColumnIndex("name")) + " " + c.getString(c.getColumnIndex("sn"));
            idx ++;
        }

//        After usage return it
        c.close();

//        Create new ArrayAdapter object with changed data and set it to list view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, student);
        listView.setAdapter(adapter);
    }

//    Implement SQLiteOpenHelper
    public class MySQLiteOpenHelper extends SQLiteOpenHelper {

        public MySQLiteOpenHelper(Context c, String name, SQLiteDatabase.CursorFactory cursor, int version) {
            super(c, name, cursor, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "create table student (id integer primary key autoincrement, name text, sn text);";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "drop table if exists student";
            db.execSQL(sql);
            onCreate(db);
        }
    }
}
