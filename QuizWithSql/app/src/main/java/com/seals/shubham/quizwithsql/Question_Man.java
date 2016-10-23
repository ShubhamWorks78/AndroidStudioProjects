package com.seals.shubham.quizwithsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by shubham on 6/27/2016.
 */
public class Question_Man extends SQLiteOpenHelper{
    static int i = 0;
    Random rand = new Random();
    public Question_Man(Context context) {
        super(context, "QuestionsSecond.db", null, 2);
    }
    static ArrayList<String> ss = new ArrayList<String>();
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create table questQuizData"+"(quest_No varchar(12) primary key not null,quest varchar(100) not null,optA varchar(40) not null,optB varchar(40) not null,optC varchar(40) not null,optD varchar(40) not null,Correct varchar(40) not null)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "Drop table if exits questQuizData";
        sqLiteDatabase.execSQL(query);
    }
    public void insertData(String quest,String optA,String optB,String optC,String optD,String corr)
    {
        i++;
        String no = ""+i;
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("quest_No",no);
        cv.put("quest",quest);
        cv.put("optA",optA);
        cv.put("optB",optB);
        cv.put("optC",optC);
        cv.put("optD",optD);
        cv.put("Correct",corr);
        database.insert("questQuizData",null,cv);
    }
    public boolean chck(String str)
    {
        if(ss.contains(str))
            return true;
        else
            return false;
    }
    public int findNo()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query;
        query = "Select * from questQuizData";
        Cursor c = database.rawQuery(query,null);
        return c.getCount();
    }
    static ArrayList<String> aa = new ArrayList<String>();
    public String findOption()
    {
        int n = 4;
        int num = rand.nextInt(n)+1;
        String str = ""+num;
        while(!aa.contains(str))
        {
            num = rand.nextInt(n)+1;
            str = ""+num;
        }
        aa.add(str);
        return str;
    }
    public String find_no()
    {
        int n = findNo();
        int num = rand.nextInt(n)+1;
        String val = ""+num;
        while (ss.contains(val))
        {
            num = rand.nextInt(n)+1;
            val = ""+num;
        }
        ss.add(val);
        return val;
    }

    public String showData(int n,String number)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from questQuizData where quest_No = '"+number+"'";
        Cursor c;
        String result = null;
        c = database.rawQuery(query,null);
        if(c.moveToNext())
        {
            result =  c.getString(n);
        }
        return result;
    }

}
