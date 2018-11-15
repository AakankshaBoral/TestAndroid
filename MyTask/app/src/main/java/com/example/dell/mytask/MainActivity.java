package com.example.dell.mytask;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button AddTask;
    RecyclerView reCyclerView;
    TaskAdapter adapter;
    ArrayList<Task> tasklist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AddTask = (Button) findViewById(R.id.addtaskbtn);
        AddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),AddTaskActivity.class);
                startActivity(intent);

            }
        });
        
        fetchtasks();
    }

    private void fetchtasks() {

        tasklist.clear();

        DBAdapter db = new DBAdapter(this);
        db.openDB();

        Cursor c = db.getAllTasks();

        while (c.moveToNext()) {
            int id = c.getInt(0);
            String taskname = c.getString(1);
            String date = c.getString(2);
            String time = c.getString(3);

            Task t = new Task(id,taskname,date,time);
            tasklist.add(t);
        }

        if (!(tasklist.size() < 1))
        {

            reCyclerView = (RecyclerView) findViewById(R.id.recyclerview);
            RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getApplicationContext());
            reCyclerView.setLayoutManager(layoutmanager);
            reCyclerView.setItemAnimator(new DefaultItemAnimator());
            reCyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
            reCyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), reCyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {

                    Task task = tasklist.get(position);
                    Toast.makeText(MainActivity.this,task.getTaskname()+" is Selected ",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

            adapter = new TaskAdapter(this,tasklist);
            reCyclerView.setAdapter(adapter);
        }

        db.closeDB();

    }
}
