package com.olegis.p0621_alertdialogitems;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    final static private String TAG = "myLogs";

    final int DIALOG_ITEMS = 1;
    final int DIALOG_ADAPTER = 2;
    final int DIALOG_CURSOR = 3;
    int cht = 0;
    DB db;
    Cursor cursor;

    String[] data = {"one", "two", "three", "four"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //открываем подключение в БД
        db = new DB(this);
        db.open();
        cursor = db.getAllData();
        startManagingCursorCursor(cursor);
    }

    public void onclick (View v){
        changeCount();
        switch (v.getId()){
            case R.id.btnItems:
                showDialog(DIALOG_ITEMS);
                break;
            case R.id.btnItems:
                showDialog(DIALOG_ADAPTER);
                break;
            case R.id.btnItems:
                showDialog(DIALOG_CURSOR);
                break;
            default:
                break;
        }
    }

}
