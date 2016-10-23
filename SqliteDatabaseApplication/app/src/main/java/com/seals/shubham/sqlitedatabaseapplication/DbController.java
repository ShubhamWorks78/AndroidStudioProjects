package com.seals.shubham.sqlitedatabaseapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shubham on 6/15/2016.
 */
public class DbController extends SQLiteOpenHelper{
    private static final String LOGCAT = null;
    public DbController(Context context) {
        super(context, "Student_details.db", null, 1);
        Log.d(LOGCAT,"Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = "Create table MyRecord (Serial_no INTEGER primary key,Name Varchar(20) not null,Roll Varchar(12) not null,Gender Varchar(6))";
        db.execSQL(query);
        Log.d(LOGCAT,"Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query = "Drop table if Exists MyRecord";
        db.execSQL(query);
        onCreate(db);
    }
    public void addData(int i,String name,String roll,String gen)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Serial_no",i);
        cv.put("Name",name);
        cv.put("Roll",roll);
        cv.put("Gender",gen);
        database.insert("MyRecord",null,cv);
    }
    public void updateData(String name,String roll)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Name",name);
        database.update("MyRecord",cv,"Roll"+" = ?",new String[] {roll});
    }
    public void deleteData(String roll)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Delete from MyRecord Where Roll = '"+roll+"'";
        database.execSQL(query);
    }
    public ArrayList showData()
    {
        ArrayAdapter<String> arrayAdapter;
        ArrayList ara = new ArrayList();
        StringBuilder arr = new StringBuilder();
        SQLiteDatabase database = this.getWritableDatabase();
        String query;
        int i =0;
        query = "Select * from MyRecord";
        Cursor c = database.rawQuery(query,null);
        while(c.moveToNext())
        {
            ara.add("Name :- "+c.getString(1)+"\n"+"Roll :- "+c.getString(2)+"\n"+"Gender :-"+c.getString(3)+"\n");
        }
        return ara;
    }
}
