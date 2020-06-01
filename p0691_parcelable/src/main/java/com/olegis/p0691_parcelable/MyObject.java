package com.olegis.p0691_parcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class MyObject implements Parcelable {

    final static String TAG = "myLogs";

    public String s;
    public int i;

    //обычный конструктор
    public MyObject (String _s, int _i){
        Log.d(TAG, "MyObject(String _s, int _i)");
        s = _s;
        i = _i;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    //упаковываем обьект в Parcel
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        Log.d(TAG, "writeToParcel");
        parcel.writeString(s);
        parcel.writeInt(i);
    }

    public static final Parcelable.Creator<MyObject> CREATOR = new Parcelable.Creator<MyObject>(){
        //распаковываем объект из Parcel
        @Override
        public MyObject createFromParcel(Parcel parcel) {
            Log.d(TAG, "createFromParcel");
            return new MyObject(parcel);
        }

        @Override
        public MyObject[] newArray(int size) {
            return new MyObject[size];
        }
    };

    //конструктор, считывающий данные из Parcel
    private MyObject(Parcel parcel){
        Log.d(TAG, "MyObject(Parcel parcel)");
        s = parcel.readString();
        i = parcel.readInt();
    }
}
