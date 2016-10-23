package com.seals.shubham.loginconfirm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by shubham on 6/16/2016.
 */
public class DbLoader extends SQLiteOpenHelper{
    public DbLoader(Context context) {
        super(context, "Registration.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query;
        query = "Create table Login "+"(Username Varchar(20) not null,Password Varchar(14) not null,Mobile Varchar(10) not null Primary key)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query;
        query = "Drop table if Exists Login";
        db.execSQL(query);
    }
    public void insertData(String user,String pass,String mobile)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Username",user);
        cv.put("Password",pass);
        cv.put("Mobile",mobile);
        database.insert("Login",null,cv);
    }
    public int chckData(String usr,String pass)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query;
        query = "SELECT Username from Login where Username='"+usr+"' AND Password = '"+pass+"'";
        Cursor c = database.rawQuery(query,null);
        if(c.moveToNext())
        {
            return 1;
        }
        else
            return 0;
    }
    public String getPhone(String usr)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select Mobile from Login where Username = '"+usr+"'";
        Cursor c = database.rawQuery(query,null);
        if(c.moveToNext())
        {
            return c.getString(0);
        }
        else
        {
            return "No";
        }
    }
}
