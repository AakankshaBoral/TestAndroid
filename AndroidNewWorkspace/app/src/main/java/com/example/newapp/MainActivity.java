package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button dial;
    EditText number;
    String mob_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dial = (Button)findViewById(R.id.dial_button);
        number = (EditText)findViewById(R.id.mobile_no_edittext);
        mob_number = number.getText().toString();

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),ExotelAPICall.class);
                startActivity(i);

            }
        });


    }

  /*  public void btnclick(View view)
    {


    }*/


}
