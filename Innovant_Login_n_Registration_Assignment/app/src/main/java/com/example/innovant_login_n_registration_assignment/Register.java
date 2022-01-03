package com.example.innovant_login_n_registration_assignment;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Register extends AppCompatActivity {

    public Button register;
    public EditText edittext_email,edittext_pass,edittext_firstname,edittext_last_name,edittext_gender,edittext_dob,edittext_phone_code,edittextphone,edittext_devicetype,edittext_devicetoken,edittext_app_version,edittext_osversion,edittext_device_model,edittext_newsletter;
    String email,pass,firstname,lastname,gender,dob,phone_code,phone,device_type,device_token,app_version,os_version,device_model,newsletter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = (Button) findViewById(R.id.btn_register);
        edittext_email = (EditText) findViewById(R.id.email);
        edittext_pass = (EditText) findViewById(R.id.password);
        edittext_firstname = (EditText) findViewById(R.id.FirstName);
        edittext_last_name = (EditText) findViewById(R.id.LastName);
        edittext_gender = (EditText) findViewById(R.id.Gender);
        edittext_dob = (EditText) findViewById(R.id.DOB);
        edittext_phone_code = (EditText) findViewById(R.id.PhoneCode);
        edittextphone = (EditText) findViewById(R.id.phonenumber);
        edittext_devicetype = (EditText) findViewById(R.id.devicetype);
        edittext_devicetoken = (EditText) findViewById(R.id.device_token);
        edittext_osversion = (EditText) findViewById(R.id.os_version);
        edittext_app_version = (EditText) findViewById(R.id.app_version);
        edittext_device_model = (EditText) findViewById(R.id.device_model);
        edittext_newsletter = (EditText) findViewById(R.id.newsletter_subscribed);

        email = edittext_email.getText().toString();
        pass = edittext_pass.getText().toString();
        firstname = edittext_last_name.getText().toString();
        lastname = edittext_firstname.getText().toString();
        gender = edittext_gender.getText().toString();
        dob = edittext_dob.getText().toString();
        phone_code = edittext_phone_code.getText().toString();
        phone = edittextphone.getText().toString();
        device_type = edittext_devicetype.getText().toString();
        device_token = edittext_devicetoken.getText().toString();
        os_version = edittext_osversion.getText().toString();
        app_version = edittext_app_version.getText().toString();
        device_model = edittext_device_model.getText().toString();
        newsletter = edittext_newsletter.getText().toString();

        register.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                edittext_email.setText("");
                edittext_pass.setText("");
                edittext_firstname.setText("");
                edittext_last_name.setText("");
                edittext_gender.setText("");
                edittext_dob.setText("");
                edittext_phone_code.setText("");
                edittextphone.setText("");
                edittext_devicetype.setText("");
                edittext_device_model.setText("");
                edittext_osversion.setText("");
                edittext_app_version.setText("");
                edittext_newsletter.setText("");
                edittext_devicetoken.setText(" ");

                class HTTPReqTask extends AsyncTask<Void, Void, Void> {
                    @SuppressLint("WrongThread")
                    @Override
                    protected Void doInBackground(Void... params) {
                        HttpURLConnection urlConnection = null;

                        try {
                            JSONObject postData = new JSONObject();
                            postData.put("email",email);
                            postData.put("pass",pass);
                            postData.put("firstname",firstname);
                            postData.put("lastname",lastname);
                            postData.put("gender",gender);
                            postData.put("dob",dob);
                            postData.put("phone_code",phone_code);
                            postData.put("phone",phone);
                            postData.put("device_type",device_type);
                            postData.put("device_token",device_token);
                            postData.put("os_version",os_version);
                            postData.put("app_version",app_version);
                            postData.put("device_mpodel",device_model);
                            postData.put("newsletter",newsletter);





                            URL url = new URL("https://admin-cp.nabra-kwt.com/api/v1/register");
                            urlConnection = (HttpURLConnection) url.openConnection();
                            urlConnection.setRequestProperty("Content-Type", "application/json");
                            urlConnection.setRequestMethod("POST");
                            urlConnection.setDoOutput(true);
                            urlConnection.setDoInput(true);
                            urlConnection.setChunkedStreamingMode(0);

                            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
                            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                                    out, "UTF-8"));
                            writer.write(postData.toString());
                            writer.flush();

                            int code = urlConnection.getResponseCode();
                            if (code !=  201) {
                                throw new IOException("Invalid response from server: " + code);
                            }

                            BufferedReader rd = new BufferedReader(new InputStreamReader(
                                    urlConnection.getInputStream()));
                            String line;
                            while ((line = rd.readLine()) != null) {
                                Log.d("Data  Posted is :----- ", line);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            if (urlConnection != null) {
                                urlConnection.disconnect();
                            }
                        }

                        return null;
                    }
                }

            }
        });
    }

    }
