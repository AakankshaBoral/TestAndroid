package com.example.dell.trata_group_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit extends AppCompatActivity {

    String firstname,lastname,dob,gender;
    int id;
    EditText edit_firstname,edit_lastname,edit_dob,edit_gender;
    Button update;
    String updated_firstname,updated_lastname,updated_dob,updated_gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        edit_firstname = (EditText)findViewById(R.id.edit_firstname_edittext);
        edit_lastname = (EditText)findViewById(R.id.edit_lastname_edittext);
        edit_dob = (EditText)findViewById(R.id.edit_dob_edittext);
        edit_gender = (EditText)findViewById(R.id.edit_gender_edittext);
        update = (Button)findViewById(R.id.btn_update);

        firstname = getIntent().getStringExtra("First Name");
        lastname = getIntent().getStringExtra("Last Name");
        dob = getIntent().getStringExtra("Date Of Birth");
        gender = getIntent().getStringExtra("Gender");
        id = getIntent().getIntExtra("Row Id",0);

        String result1 = String.valueOf(id);

        Log.d("Recieved row Id is :- ",result1);

        edit_firstname.setText(firstname);
        edit_lastname.setText(lastname);
        edit_dob.setText(dob);
        edit_gender.setText(gender);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int result;
                updated_firstname = edit_firstname.getText().toString();
                updated_lastname = edit_lastname.getText().toString();
                updated_dob = edit_dob.getText().toString();
                updated_gender = edit_gender.getText().toString();

                edit_firstname.setText("");
                edit_lastname.setText("");
                edit_dob.setText("");
                edit_gender.setText("");

                DBAdapter db = new DBAdapter(getApplicationContext());
                db.openDB();

                result = db.updatedetails(id,updated_firstname,updated_lastname,updated_dob,updated_gender);

                if (result>0)
                    Toast.makeText(getApplicationContext(),"Details Updated successfully in Database.....",Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getApplicationContext(),"Unable to update details....",Toast.LENGTH_LONG).show();
            }
        });

    }
}