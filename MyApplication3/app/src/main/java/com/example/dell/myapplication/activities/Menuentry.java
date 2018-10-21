package com.example.dell.myapplication.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.myapplication.R;

public class Menuentry extends AppCompatActivity {

    EditText Menuname;
    EditText Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuentry);

        Menuname = (EditText)findViewById(R.id.menunameedittext);
        Price = (EditText)findViewById(R.id.priceedittxt);
    }

    public void insert(View view)
    {
        String menu,price;
        menu = Menuname.getText().toString();
        price = Price.getText().toString();
        Menuname.setText("");
        Price.setText("");
        DBAdapter db = new DBAdapter(this);
        db.openDB();
        long result = db.add(menu,price);
        if (result>0)
            Toast.makeText(this,"Menu Name & Price Inserted In Database",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Unable To Insert Menu In Database",Toast.LENGTH_SHORT).show();
        db.closeDB();
    }
}


