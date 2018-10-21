package com.example.dell.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dell.myapplication.R;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     //   String refreshedToken = FirebaseInstanceId.getInstance().getToken();

    }

    public void customer(View view)
    {
        Intent intent = new Intent(MainActivity.this,HoteMenuList.class);
        startActivity(intent);
    }

    public void owner (View view)
    {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void waiter(View view)
    {
        Intent intent = new Intent(MainActivity.this,Waiter_login.class);
        startActivity(intent);
        finish();
    }
}
