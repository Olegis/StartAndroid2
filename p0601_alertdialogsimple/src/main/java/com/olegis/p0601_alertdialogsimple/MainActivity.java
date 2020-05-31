package com.olegis.p0601_alertdialogsimple;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final int DIALOG_EXIT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View view) {
        //вызываем диалог
        showDialog(DIALOG_EXIT);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            //заголовок
            adb.setTitle(R.string.exit);
            //сообщение
            adb.setMessage(R.string.save_data);
            //иконка
            adb.setIcon(android.R.drawable.ic_dialog_info);
            //кнопка положительного ответа
            adb.setPositiveButton(R.string.yes, myClickListener);
            //кнопка отрицательного ответа
            adb.setNegativeButton(R.string.no, myClickListener);
            //кнопка нейтрального ответа
            adb.setNeutralButton(R.string.cancel, myClickListener);
            //создаем диалог
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    savedData();
                    finish();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    finish();
                    break;
                case Dialog.BUTTON_NEUTRAL:
                    break;
            }
        }
    };

    void savedData() {
        Toast.makeText(this, R.string.saved, Toast.LENGTH_SHORT).show();
    }


    public void onBackPressed() {
        //вызываем диалог
        showDialog(DIALOG_EXIT);
    }
}
