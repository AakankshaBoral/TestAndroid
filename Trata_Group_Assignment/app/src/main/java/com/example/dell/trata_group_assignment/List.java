package com.example.dell.trata_group_assignment;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity {

    CustomAdapter adapter;
    ArrayList<Personal_Details> detailslist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
      //  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Details.class);
                startActivity(intent);
            }
        });

        fetchdetails();
    }

    private void fetchdetails() {

        detailslist.clear();
        DBAdapter db = new DBAdapter(this);
        db.openDB();

        Cursor c = db.getAllDetails();

        while (c.moveToNext())
        {

            int id = c.getInt(0);
            String firstname = c.getString(1);
            String lastname = c.getString(2);
            String dob = c.getString(3);
            String gender = c.getString(4);

            Personal_Details p = new Personal_Details(id,firstname,lastname,dob,gender);
            detailslist.add(p);
        }

        if (!(detailslist.size()<1))
        {

            RecyclerView recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
            RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getApplicationContext());
            recyclerview.setLayoutManager(layoutmanager);
            recyclerview.setItemAnimator(new DefaultItemAnimator());
            recyclerview.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
            recyclerview.addOnItemTouchListener(new RecyclerTouchlistner(getApplicationContext(),recyclerview, new RecyclerTouchlistner.ClickListener() {
                @Override
                public void onClick(View view, int position) {

                    Intent i = new Intent(getApplicationContext(),Edit.class);
                    i.putExtra("Row Id",detailslist.get(position).getId());
                    i.putExtra("First Name",detailslist.get(position).getFirst_name());
                    i.putExtra("Last Name",detailslist.get(position).getLast_name());
                    i.putExtra("Date Of Birth",detailslist.get(position).getDate_of_birth());
                    i.putExtra("Gender",detailslist.get(position).getGender());
                    startActivity(i);
                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

            adapter = new CustomAdapter(this,detailslist);
            recyclerview.setAdapter(adapter);
        }

    }

}
