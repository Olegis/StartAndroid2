package com.olegis.p0531_simplecursortreeadapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB {

    private static final String DB_NAME = "mybd";
    private static final int BD_VERSION = 1;

    // имя таблицы компаний, поля и запрос создания
    private static final String COMPANY_TABLE = "company";
    public static final String COMPANY_COLUMN_ID = "_id";
    public static final String COMPANY_COLUMN_NAME = "name";
    private static final String COMPANY_TABLE_CREATE = "create table "
            + COMPANY_TABLE + "(" + COMPANY_COLUMN_ID
            + "integer primary key, " + COMPANY_COLUMN_NAME + " text" + ");";

    // имя таблицы телефонов, поля и запрос создания
    private static final String PHONE_TABLE = "phone";
    public static final String PHONE_COLUMN_ID = "_id";
    public static final String PHONE_COLUMN_NAME = "name";
    public static final String PHONE_COLUMN_COMPANY = "company";
    private static final String PHONE_TABLE_CREATE = "create table"
            + PHONE_TABLE + "(" + PHONE_COLUMN_ID
            + "integer primary key autoincrement, " + PHONE_COLUMN_NAME
            + " text, " + PHONE_COLUMN_COMPANY + " integer" + ");";

    private final Context mCtx;

    private DBHelper mDBHelper;
    private SQLiteDatabase mDB;

    public DB(Context ctx) {
        mCtx = ctx;
    }

    //открываем подключение


    private class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            ContentValues cv = new ContentValues();

            //названия компаний(групп)
            String[] companies = {"HTC", "Samsung", "LG"};

            //создаем и заполняем таблицу компаний
            db.execSQL(COMPANY_TABLE_CREATE);
            for (int i = 0; i < companies.length; i++) {
                cv.put(COMPANY_COLUMN_ID, i + 1);
                cv.put(COMPANY_COLUMN_ID, companies[i]);
                db.insert(COMPANY_TABLE, null, cv);
            }

            //названия телефонов (элементов)
            String[] phonesHTC = {"Sensation", "Desire", "Wildfire", "Hero"};
            String[] phonesSams = {"Galaxy S II", "Galaxy Nexus", "Wave"};
            String[] phonesLG = {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};

            // создаем и заполняем таблицу компаний
            db.execSQL(COMPANY_TABLE_CREATE);
            cv.clear();
            for (int i = 0; i < phonesHTC.length; i++) {
                cv.put(PHONE_COLUMN_COMPANY, 1);
                cv.put(COMPANY_COLUMN_NAME, phonesHTC[i]);
                db.insert(PHONE_TABLE, null, cv);
            }
            for (int i = 0; i < phonesSams.length; i++) {
                cv.put(PHONE_COLUMN_COMPANY, 2);
                cv.put(COMPANY_COLUMN_NAME, phonesSams[i]);
                db.insert(PHONE_TABLE, null, cv);
            }
            for (int i = 0; i < phonesLG.length; i++) {
                cv.put(PHONE_COLUMN_COMPANY, 3);
                cv.put(COMPANY_COLUMN_NAME, phonesLG[i]);
                db.insert(PHONE_TABLE, null, cv);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
