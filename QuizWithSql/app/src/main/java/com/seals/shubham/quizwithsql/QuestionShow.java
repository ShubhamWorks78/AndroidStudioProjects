package com.seals.shubham.quizwithsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by shubham on 6/23/2016.
 */
public class QuestionShow extends SQLiteOpenHelper{
    static ArrayList<String> marks = new ArrayList<String>();
    public void chcked(String value)
    {
        int len = marks.size();
        String valS = marks.get(len);
        int val = Integer.parseInt(valS);
        int vaa = Integer.parseInt(value);
        if(vaa>val)
        {
            marks.remove(marks.size()-1);
            marks.add(value);
        }
    }
    public ArrayList markShow()
    {
        return marks;
    }
    static int i = 0;
    Random rand = new Random();
    public QuestionShow(Context context) {
        super(context, "Questions.db", null, 2);
    }
    static ArrayList<String> ss = new ArrayList<String>();
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create table questQuizAdd"+"(quest_No varchar(12) primary key not null,quest varchar(100) not null,optA varchar(40) not null,optB varchar(40) not null,optC varchar(40) not null,optD varchar(40) not null,Correct varchar(40)not null)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "Drop table if exits questQuizAdd";
        sqLiteDatabase.execSQL(query);
    }
    public void refresh()
    {
        int i = 0;
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select quest_No,quest from questQuizAdd ORDER BY quest_No";
        Cursor c = database.rawQuery(query,null);
        int lng = c.getCount();
        while(c.moveToNext())
        {
            i++;
            String no = c.getString(0);
            String quest = c.getString(1);
            this.updateNo(no,quest,i);
        }
    }

    private void updateNo(String no, String quest, int i) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        String val = ""+i;
        Log.w("no",val);
        Log.w("quest",quest);
        String query = "Update questQuizAdd set quest_No = '"+val+"' WHERE quest = '"+quest+"'";
        database.execSQL(query);
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
        database.insert("questQuizAdd",null,cv);
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
        query = "Select * from questQuizAdd";
        Cursor c = database.rawQuery(query,null);
        return c.getCount();
    }
    static ArrayList<String> aa = new ArrayList<String>();
    public int findOption()
    {
        int n = 4;
        int num = rand.nextInt(n)+1;
        String str = ""+num;
        while(aa.contains(str))
        {
            num = rand.nextInt(n)+1;
            str = ""+num;
        }
        aa.add(str);
        return num;
    }
    public int length()
    {
        return ss.size();
    }
    public int chckNo()
    {
        int ques_No = findNo();
        int ques_dealt = ss.size();
        if((ques_No-ques_dealt)==1)
            return 1;
        else
            return 0;
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
    public void empty()
    {
        ss.clear();
    }
    public void print()
    {
        Log.w("Arr",""+ss);
    }
    public String showData(int n,String number)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from questQuizAdd where quest_No = '"+number+"'";
        Cursor c;
        String result = null;
        c = database.rawQuery(query,null);
        if(c.moveToNext())
        {
            result =  c.getString(n);
        }
        return result;
    }
    public ArrayList allQues()
    {
        ArrayList arr = new ArrayList();
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from questQuizAdd ORDER BY quest_No";
        Cursor c = database.rawQuery(query,null);
        while(c.moveToNext())
        {
            arr.add("Q."+c.getString(0)+". "+c.getString(1));
        }
        return arr;
    }
    public void clear()
    {
        for(int i=0;i<4;i++)
        {
            aa.clear();
        }
    }
    public void updateQuestion(String quest_no,String quest,String opa,String opb,String opc,String opd,String corr)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("quest",quest);
        cv.put("optA",opa);
        cv.put("optB",opb);
        cv.put("optC",opc);
        cv.put("optD",opd);
        cv.put("Correct",corr);
        database.update("questQuizAdd",cv,"quest_No="+quest_no,null);
    }
    public void DeleteQuestion(String str)
    {
        Log.w("No",str);
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Delete from questQuizAdd where quest_No = '"+str+"'";
        database.execSQL(query);
    }
    public HashMap<String,String> getQuestion(String quest){
        int pos;
        pos = quest.indexOf(" ");
        Log.w("ME",quest.substring(pos,quest.length()));
        pos +=1;
        int i = 2,j;
        String myStr = quest.substring(pos,quest.length());
        Log.w("Question",myStr);
        String ques = quest.substring(pos+1);
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "Select * from questQuizAdd where quest = '"+myStr+"'";
        Cursor c = database.rawQuery(query,null);
        HashMap<String,String> param = new HashMap<String,String>();
        if(c.moveToNext())
        {
            param.put("Quest_No",c.getString(0));
            param.put("Question",c.getString(1));
            param.put("OptA",c.getString(2));
            param.put("OptB",c.getString(3));
            param.put("OptC",c.getString(4));
            param.put("OptD",c.getString(5));
            param.put("Correct",c.getString(6));
        }
        else if(!(c.moveToFirst()) || (c.getCount()==0))
            Log.w("Output","No values");
        return param;
    }
}
