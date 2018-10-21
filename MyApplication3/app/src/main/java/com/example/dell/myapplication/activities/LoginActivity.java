package com.example.dell.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.dell.myapplication.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class
LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private ProgressBar progressBar;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private Button btnSignup, btnLogin, btnReset,menuentry;
    String TAG = "LOG:";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Get Firebase auth instance
            auth = FirebaseAuth.getInstance();

            mAuthListener = new FirebaseAuth.AuthStateListener() {
                @Override
                public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                    FirebaseUser user = firebaseAuth.getCurrentUser();
                    if(user != null)
                    {
                        //User is signed in

                        Log.d(TAG,"onAuthStateChanged:signed _in:"+user);

                    }
                    else
                    {

                        Log.d(TAG,"onAuthStateChanged:signed_out"+user);
                    }
                }
            };

            if (auth.getCurrentUser() != null) {
                startActivity(new Intent(LoginActivity.this, Owner_todo.class));
                finish();
            }

            // set the view now
            setContentView(R.layout.activity_login);

            inputEmail = (EditText) findViewById(R.id.email);
            inputPassword = (EditText) findViewById(R.id.password);
            progressBar = (ProgressBar) findViewById(R.id.progressBar);
            btnSignup = (Button) findViewById(R.id.btn_signup);
            btnLogin = (Button) findViewById(R.id.btn_login);
            btnReset = (Button) findViewById(R.id.btn_reset_password);
            menuentry = (Button) findViewById(R.id.enter_menu);

            //Get Firebase auth instance
            auth = FirebaseAuth.getInstance();

            btnSignup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                }
            });

            btnReset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
                }
            });

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String email = inputEmail.getText().toString();
                    final String password = inputPassword.getText().toString();

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    progressBar.setVisibility(View.VISIBLE);

                    //authenticate user
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {

                            Log.d(TAG, "signInWithEmail:onComplete:" + task.isSuccessful());
                            progressBar.setVisibility(View.GONE);
                            if (!task.isSuccessful())
                            {
                                Log.w(TAG, "signInWithEmail:failed", task.getException());

                                if (password.length() < 6) {
                                    inputPassword.setError(getString(R.string.minimum_password));

                                } else {
                                    Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();

                                }


                            }
                            else
                            {

                                if (email.equals("aakankshaboral@yahoo.com")) {
                                    Intent intent = new Intent(LoginActivity.this, Owner_todo.class);
                                    startActivity(intent);
                                    finish();
                                }
                                else
                                {
                                    Intent intent = new Intent(LoginActivity.this,Waiter_dashboard.class);
                                    startActivity(intent);
                                    finish();
                                }

                            }
                    }
                });



            }
    });
}

    public  void owner_dashboard(View view)
    {
        Intent intent = new Intent(LoginActivity.this,FirebaseActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        auth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (mAuthListener != null)
        {
            auth.removeAuthStateListener(mAuthListener);
        }
    }
}





