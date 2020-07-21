package com.olegis.p0751_files;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    final String TAG = "myLogs";

    final String FILENAME = "file";

    final String DIR_SD = "MyFiles";
    final String FILENAME_SD = "fileSD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onclick(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                writeFile();
                break;
            case R.id.btnRead:
                readFile();
                break;
            case R.id.btnWriteSD:
                writeFileSD();
                break;
            case R.id.btnReadSD:
                readFileSD();
                break;
        }
    }

    void writeFile() {
        try {
            //открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(openFileOutput(FILENAME, MODE_PRIVATE)));
            //пишем данные
            bw.write("Содержимое файла");
            //закрываем поток
            bw.close();
            Log.d(TAG, "Файл записан");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFile() {
        try {
            //открываем поток для чтения
            BufferedReader br = new BufferedReader(new InputStreamReader(openFileInput(FILENAME)));
            String str = "";
            //читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d(TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void writeFileSD() {
        //проверяем доступность SD
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.d(TAG, "SD карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        //получаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        //добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        //создаем каталог
        sdPath.mkdirs();
        //формируем объект File, который сшдержит путь к файлу
        File sdFile = new File(sdPath, FILENAME_SD);
        try {
            //открываем поток для записи
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            //пишем данные
            bw.write("Содержимое файла на SD");
            //закрываем поток
            bw.close();
            Log.d(TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readFileSD() {
        //проверяем доятупность SD
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Log.d(TAG, "SD карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        //получкаем путь к SD
        File sdPath = Environment.getExternalStorageDirectory();
        //добавляем свой каталог к пути
        sdPath = new File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        //формируем обьект File, который содержит путь к файлу
        File sdFile = new File(sdPath, FILENAME_SD);
        try {
            //открываем поток для чтения
            BufferedReader br = new BufferedReader(new FileReader(sdFile));
            String str = "";
            //читаем содержимое
            while ((str = br.readLine()) != null) {
                Log.d(TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

