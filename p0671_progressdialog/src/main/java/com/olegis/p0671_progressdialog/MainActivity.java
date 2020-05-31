package com.olegis.p0671_progressdialog;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ProgressDialog pd;
    Handler h;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.btnDefault:
                pd = new ProgressDialog(this);
                pd.setTitle("Title");
                pd.setMessage("Message");
                //добавляем кнопку
                pd.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                    }
                });
                pd.show();
                break;
            case R.id.btnHoriz:
                pd = new ProgressDialog(this);
                pd.setTitle("Title");
                pd.setMessage("Message");
                //меняем стиль на индикатор
                pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //устанавливаем максимум
                pd.setMax(2148);
                //включаем анамацию ожидания
                pd.setIndeterminate(true);
                pd.show();
                h = new Handler() {
                    public void handleMessage(Message msg) {
                        //включаем анимацию ожидания
                        pd.setIndeterminate(false);
                        if (pd.getProgress() < pd.getMax()) {
                            //увеличиваем значение индикаторов
                            pd.incrementProgressBy(50);
                            pd.incrementSecondaryProgressBy(75);
                            h.sendEmptyMessageDelayed(0, 100);
                        } else {
                            pd.dismiss();
                        }
                    }
                };
                h.sendEmptyMessageDelayed(0, 2000);
                break;
            default:
                break;
        }
    }
}
