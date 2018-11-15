package com.example.dell.mytask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity {

    Button inserttask,back;
    EditText taskname,dateedit,timeedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        inserttask = (Button) findViewById(R.id.insertbtn);
        taskname = (EditText)findViewById(R.id.tasknameedittext);
        dateedit = (EditText)findViewById(R.id.datedittxt);
        timeedit = (EditText)findViewById(R.id.timeedittxt);
        back = (Button)findViewById(R.id.backbtn);

        inserttask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String task,date,time;
                task = taskname.getText().toString();
                date = dateedit.getText().toString();
                time = timeedit.getText().toString();
                taskname.setText("");
                dateedit.setText("");
                timeedit.setText("");
                DBAdapter db = new DBAdapter(getApplicationContext());
                db.openDB();
                long result = db.add(task,date,time);
                if (result>0)
                    Toast.makeText(getApplicationContext(),"Task Inserted In Database",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"Unable To Insert Task In Database",Toast.LENGTH_SHORT).show();
                db.closeDB();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });
    }
}
