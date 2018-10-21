package com.example.dell.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dell.myapplication.R;

public class Owner_todo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_todo);
    }

    public void menu_entry(View view)
    {
        Intent intent = new Intent(this,Menuentry.class);
        startActivity(intent);
    }



    public void show_menu_list(View view)
    {
        Intent intent = new Intent(this,HoteMenuList.class);
        startActivity(intent);
    }




}
