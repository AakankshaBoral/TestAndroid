package com.example.dell.trata_group_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button login;
    EditText email_edit,pass_edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = (Button)findViewById(R.id.login_button);
        email_edit = (EditText) findViewById(R.id.email_edit_text);
        pass_edit = (EditText) findViewById(R.id.password_edit_text);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final  String email;
                final String pass;
                email = email_edit.getText().toString();
                pass = pass_edit.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (email.equals("admin")&&pass.equals("admin"))
                {
                    Intent i = new Intent(MainActivity.this,List.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Enter valid email id & password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
