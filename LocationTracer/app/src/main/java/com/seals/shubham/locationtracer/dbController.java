package com.seals.shubham.locationtracer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by shubham on 6/17/2016.
 */
public class dbController extends SQLiteOpenHelper{
    public dbController(Context context) {
        super(context, "Location.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = "Create table AddLocation "+"(Latitude double,Longitude double,Address Varchar(135))";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query = "Drop table if Exists AddLocation";
        db.execSQL(query);
    }
    public void insertData(int lat,int lng,String loc)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Latitude",lat);
        cv.put("Longitude",lng);
        cv.put("Address",loc);
        database.insert("AddLocation",null,cv);
    }
    public ArrayList showData()
    {
        ArrayList arr = new ArrayList();
        ArrayAdapter<String> ad;
        String query;
        SQLiteDatabase database = this.getWritableDatabase();
        query = "Select * from AddLocation";
        Cursor c = database.rawQuery(query,null);
        while(c.moveToNext())
        {
            arr.add("Latitude:- "+c.getString(0)+"\n"+"Longitude:- "+c.getString(1)+"\n"+"Address:- "+c.getString(2));
        }
        return arr;
    }
}
