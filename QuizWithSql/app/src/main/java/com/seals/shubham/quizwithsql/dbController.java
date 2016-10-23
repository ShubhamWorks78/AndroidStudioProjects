package com.seals.shubham.quizwithsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by shubham on 6/23/2016.
 */
public class dbController extends SQLiteOpenHelper{
    public dbController(Context context) {
        super(context, "LoginData.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create table LoginDb (Username varchar(20) not null primary key,Password varchar(15) not null,Mobile varchar(10) not null,Gender varchar(6) not null,Type varchar(5) not null)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query;
        query = "Drop table if exists LoginDb";
        sqLiteDatabase.execSQL(query);
    }
    public void insertData(String user,String pass,String mob,String gen,String type)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Username",user);
        cv.put("Password",pass);
        cv.put("Mobile",mob);
        cv.put("Gender",gen);
        cv.put("Type",type);
        database.insert("LoginDb",null,cv);
    }
    public int chckData(String user, String pass)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor c = database.rawQuery("Select Username from LoginDb where Username ='"+user+"' AND Password = '"+pass+"'",null);
        if(c.moveToNext())
        {
            return 1;
        }
        else
            return 0;
    }
    public String val(String user)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query;
        query = "Select Mobile from LoginDb where Username = '"+user+"'";
        Cursor c = database.rawQuery(query,null);
        if(c.moveToNext())
            return c.getString(0);
        else
            return null;
    }
    public String getPass(String user)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query;
        query = "Select Password from LoginDb Where Username = '"+user+"'";
        Cursor c = database.rawQuery(query,null);
        if(c.moveToNext())
            return c.getString(0);
        else
            return null;
    }
    public int updatePassword(String user,String pass)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Password",pass);
        database.update("LoginDb",cv,"Username = "+user,null);
        if(getPass(user).equals(pass))
            return 1;
        else
            return 0;
    }
    public String getType(String name,String pass)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from LoginDb Where Username = '"+name+"' AND Password = '"+pass+"'";
        Cursor c = database.rawQuery(query,null);
        if(c.moveToNext())
        {
            return c.getString(4);
        }
        else
        {
            return c.getString(4);
        }
    }
}
