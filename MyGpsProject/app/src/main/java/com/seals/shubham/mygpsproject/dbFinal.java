package com.seals.shubham.mygpsproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by shubham on 6/21/2016.
 */
public class dbFinal extends SQLiteOpenHelper{
    public dbFinal(Context context) {
        super(context, "ShubhamProject.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query;
        query = "Create table highTime (myTime varchar(15) not null,Latitude varchar(14) not null,Longitude varchar(14) not null,Address varchar(80))";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query;
        query = "Drop table if exists highTime";
        sqLiteDatabase.execSQL(query);
    }
    public void insertData(String time,String lat,String lng,String add)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("myTime",time);
        cv.put("Latitude",lat);
        cv.put("Longitude",lng);
        cv.put("Address",add);
        database.insert("highTime",null,cv);
    }
    public ArrayList show()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query;
        query = "Select * from highTime";
        Cursor c = database.rawQuery(query,null);
        ArrayList arr = new ArrayList();
        while (c.moveToNext())
        {
            arr.add("Time:- "+c.getString(0)+"\n"+"Latitude:- "+c.getString(1)+"\n"+"Longitude:- "+c.getString(2)+"\n"+"Address:- "+c.getString(3)+"\n");
        }
        return arr;
    }
    public void delete()
    {
        String query;
        query = "Delete from highTime";
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(query);
    }
}
