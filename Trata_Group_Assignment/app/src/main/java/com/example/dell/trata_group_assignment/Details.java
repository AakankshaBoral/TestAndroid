package com.example.dell.trata_group_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    EditText first_name_edit,last_name_edit,dob_edit,gender_edit;
    Button save,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        first_name_edit = (EditText)findViewById(R.id.first_name_edit_text);
        last_name_edit = (EditText) findViewById(R.id.last_name_edit_text);
        dob_edit = (EditText)findViewById(R.id.dob_edit_text);
        gender_edit = (EditText) findViewById(R.id.gender_edit_text);

        save = (Button) findViewById(R.id.save_button);
        back = (Button)findViewById(R.id.back_button);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String firstname;
                final String lastname;
                final String dob;
                final String gender;

                firstname = first_name_edit.getText().toString();
                lastname = last_name_edit.getText().toString();
                dob = dob_edit.getText().toString();
                gender = gender_edit.getText().toString();

                first_name_edit.setText("");
                last_name_edit.setText("");
                dob_edit.setText("");
                gender_edit.setText("");

                DBAdapter dbAdapter = new DBAdapter(Details.this);
                dbAdapter.openDB();
                long result = dbAdapter.add(firstname,lastname,dob,gender);
                String result1 = String.valueOf(result);
                Log.d("Result of Insertion",result1);
                if (result>0)
                {
                    Toast.makeText(getApplicationContext(),"Details Inserted in Database",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Unable To Insert Details In Database",Toast.LENGTH_LONG).show();
                }

                dbAdapter.closeDB();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),List.class);
                startActivity(i);
            }
        });

    }
}
