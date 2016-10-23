package com.seals.shubham.quizwithsql;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowAllQuestion extends AppCompatActivity {
    ProgressDialog pd;
    List<String> arr;
    String[] arrayOfStrings;
    QuestionShow db = new QuestionShow(this);
    ListView listView;
    Button refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_question);
        listView = (ListView)findViewById(R.id.listView);
        arr = new ArrayList<String>();
        refresh = (Button)findViewById(R.id.btnRefresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyTask ans = new MyTask();
                ans.execute();
            }
        });
        arr = db.allQues();
        arrayOfStrings = arr.toArray(new String[arr.size()]);
        Toast.makeText(this,""+arr.toString(),Toast.LENGTH_LONG).show();
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        listView.setAdapter(ad);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId()==R.id.listView)
        {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            menu.setHeaderTitle(arrayOfStrings[info.position]);
            String[] menuItems = getResources().getStringArray(R.array.MenuItem);
            for(int i = 0;i<menuItems.length;i++)
            {
                menu.add(Menu.NONE,i,i,menuItems[i]);
            }
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int menuItemIndex = item.getItemId();
        String[] menuItems = getResources().getStringArray(R.array.MenuItem);
        String menuItemName = menuItems[menuItemIndex];
        String listItemName = arrayOfStrings[info.position];
        if(menuItemIndex==0)
        {
            Intent i = new Intent(ShowAllQuestion.this,ShowSingleQuest.class);
            i.putExtra("Question",listItemName);
            startActivity(i);
        }
        else if(menuItemIndex==1)
        {
            int finalP = listItemName.length();
            int first = listItemName.indexOf(" ")-1;
            String quest_no = listItemName.substring(2,first);
            db.DeleteQuestion(quest_no);
        }
        else if(menuItemIndex==2)
        {
            Intent i = new Intent(ShowAllQuestion.this,UpdateQuestions.class);
            i.putExtra("Question",listItemName);
            startActivity(i);
        }
        return true;
    }
    public class MyTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            db.refresh();
            for(int i=0;i<123456;i++)
            {

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(ShowAllQuestion.this);
            pd.setMessage("Refreshing");
            pd.show();
        }
//ankita.dadheech769@gmail.com
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            pd.dismiss();
        }
    }
}
