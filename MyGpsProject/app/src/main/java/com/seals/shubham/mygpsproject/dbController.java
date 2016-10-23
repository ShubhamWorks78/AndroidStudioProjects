package com.seals.shubham.mygpsproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by shubham on 6/20/2016.
 */
public class dbController extends SQLiteOpenHelper{
    public dbController(Context context) {
        super(context, "GpsProject.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query;
        query = "Create table timeLocate "+"(TimeTab varchar(15) not null,Latitude varchar(15) not null,Longitude varchar(15) not null,Address varchar(100) not null)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query;
        query = "Drop table if exists timeLocate";
        sqLiteDatabase.execSQL(query);
    }
    public void insertData(String time,String lat,String lng,String add)
    {
        SQLiteDatabase sqLiteOpenHelper = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("TimeTab",time);
        cv.put("Latitude",lat);
        cv.put("Longitude",lng);
        cv.put("Address",add);
        sqLiteOpenHelper.insert("timeLocate",null,cv);
    }
    public ArrayList showData()
    {
        ArrayList arr = new ArrayList();
        SQLiteDatabase database;
        database = this.getWritableDatabase();
        String query = "Select * from timeLocate";
        Cursor c = database.rawQuery(query,null);
        while(c.moveToNext())
        {
            arr.add("Time:- "+c.getString(0)+"\n"+"Latitude:- "+c.getString(1)+"\n"+"Longitude:- "+c.getString(2)+"\n"+"Address:- "+c.getString(3)+"\n");
        }
        return arr;
    }

    public void clear() {
        String query = "DELETE from timeLocate";
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(query);
    }
}
