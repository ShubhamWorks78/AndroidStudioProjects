package com.seals.shubham.quizwithsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by shubham on 7/13/2016.
 */
public class AnswerDb extends SQLiteOpenHelper{
    static int i = 0;
    public AnswerDb(Context context) {
        super(context, "Answer.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create table AnsDb ( Question_no varchar(12) not null primary key,Original_no varchar(12) not null,UsrAns varchar(40) not null,CorrAns varchar(40) not null";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "Drop table if exists Ans";
        sqLiteDatabase.execSQL(query);
    }
    public void insert(String quest_No,String orig_No,String corr,String user)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("Question_no",quest_No);
        cv.put("Original_no",orig_No);
        cv.put("CorrAns",corr);
        cv.put("UsrAns",user);
        database.insert("AnsDb",null,cv);
    }
    public ArrayList getAll()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from AnsDb Order BY Question_no";
        ArrayList arr = new ArrayList();
        Cursor c = database.rawQuery(query,null);
        while(c.moveToNext())
        {
            arr.add("Q."+c.getString(0)+".\t"+c.getString(2));
        }
        return arr;
    }
    public String getUsrAns(String quest)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select UsrAns where Question_no = '"+quest+"'";
        Cursor c = database.rawQuery(query,null);
        if(c.moveToNext())
            return c.getString(0);
        else
            return null;
    }
    public int updateAns(String quest,String ans)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("UsrAns",ans);
        database.update("AnsDb",cv,"Question_no = "+quest,null);
        if(this.getUsrAns(quest).equals(ans))
            return 1;
        else
            return 0;
    }
    public String getQuestionNo(String quest)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select Original_no from AnsDb where Question_no = '"+quest+"'";
        Cursor c = database.rawQuery(query,null);
        if(c.moveToNext())
            return c.getString(0);
        else
            return null;
    }
    public void deleteAll()
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Delete * from Ans";
        database.execSQL(query);
    }
    public ArrayList getTable()
    {
        ArrayList arr = new ArrayList();
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select quest_No,UsrAns from Ans";
        Cursor c = database.rawQuery(query,null);
        while(c.moveToNext())
        {
            arr.add("Q."+c.getString(0)+". "+c.getString(1)+"\t"+c.getString(2));
        }
        return arr;
    }
}
