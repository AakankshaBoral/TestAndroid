package com.example.dell.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dell.myapplication.R;

public class Owner_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);
    }

    public  void goto_ownertodo(View view)
    {
        Intent intent = new Intent(this,Owner_todo.class);
        startActivity(intent);
    }

    public void owner_registration(View view)
    {
        Intent intent = new Intent(this,Owner_registration.class);
        startActivity(intent);
    }
}
