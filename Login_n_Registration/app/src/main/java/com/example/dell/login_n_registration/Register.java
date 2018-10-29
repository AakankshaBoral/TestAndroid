package com.example.dell.login_n_registration;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Register extends AppCompatActivity {

    Button Login,Register;
    TextView connectivity,jsonresult;
    EditText fname,lname,gender,dob,mobileno,email_edit,pass_edit,flatno,wingno,address,maritalstatus,famcount,education,occupation,anivdate;
    String First_Name,Last_Name,Gender,DOB,Mobile_No,Email_ID,Password,Flat_No,Wing_No,Address,Marital_Status,Fam_count,Education,Occupation,Aniv_Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Login = (Button) findViewById(R.id.login);
        Register = (Button) findViewById(R.id.register);

        connectivity = (TextView) findViewById(R.id.register_connectivity);
        jsonresult = (TextView) findViewById(R.id.register_jsonresulttextview);

        fname = (EditText) findViewById(R.id.firstnameedittext);
        lname = (EditText) findViewById(R.id.lastnameedittext);
        gender = (EditText) findViewById(R.id.genderedittext);
        dob = (EditText) findViewById(R.id.dobedittext);
        mobileno = (EditText) findViewById(R.id.mobilenoedittext);
        email_edit = (EditText)findViewById(R.id.registeremailedittext);
        pass_edit = (EditText) findViewById(R.id.registerpassedittext);
        flatno = (EditText)findViewById(R.id.flatnoedittext);
        wingno = (EditText)findViewById(R.id.wingnoedittext);
        address = (EditText)findViewById(R.id.addressedittext);
        maritalstatus = (EditText) findViewById(R.id.maritalstatusedittext);
        famcount = (EditText)findViewById(R.id.familycountedittext);
        education = (EditText)findViewById(R.id.educationedittext);
        occupation = (EditText)findViewById(R.id.occupationedittext);
        anivdate = (EditText)findViewById(R.id.anniversaryedittext);

        First_Name = fname.getText().toString();
        Last_Name = lname.getText().toString();
        Gender = gender.getText().toString();
        DOB = dob.getText().toString();
        Mobile_No = mobileno.getText().toString();
        Email_ID = email_edit.getText().toString();
        Password = pass_edit.getText().toString();
        Flat_No = flatno.getText().toString();
        Wing_No = wingno.getText().toString();
        Address = address.getText().toString();
        Marital_Status = maritalstatus.getText().toString();
        Fam_count = famcount.getText().toString();
        Education = education.getText().toString();
        Occupation = occupation.getText().toString();
        Aniv_Date = anivdate.getText().toString();

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fname.setText("");
                lname.setText("");
                gender.setText("");
                dob.setText("");
                mobileno.setText("");
                email_edit.setText("");
                pass_edit.setText("");
                flatno.setText("");
                wingno.setText("");
                address.setText("");
                maritalstatus.setText("");
                famcount.setText("");
                education.setText("");
                occupation.setText("");
                anivdate.setText("");

                if (checkConnectivity()) {

                    new HTTPAsyncTask().execute("http://test.web.api.acorsociety.com/api/users/userregistrationasync");
                    Toast.makeText(getApplicationContext(),"Connected...",Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(getApplicationContext(),"Error....Not Connected...",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private boolean checkConnectivity() {

        ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isconnected = false;

        if (networkInfo != null && (isconnected = networkInfo.isConnected()))
        {
            connectivity.setText("Connected...."+networkInfo.getTypeName());
            Toast.makeText(getApplicationContext(),"User Registration Was Successfully Done...",Toast.LENGTH_LONG).show();
        }
        else
        {
            connectivity.setText("Not Connected");
            Toast.makeText(getApplicationContext(),"Not Connectec To Internet...",Toast.LENGTH_LONG).show();
        }

        return isconnected;
    }

    private class HTTPAsyncTask extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... urls) {

            try {

                try {

                    return post(urls[0]);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return "Error...";
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
           // connectivity.setText(result);
        }
    }

    private String post(String jsonurl) throws IOException, JSONException {

        String result = "";

        URL url = new URL(jsonurl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json;charset=utf-8");

        JSONObject jsonObject = buildJsonObject();
        setPostRequestcontect(connection,jsonObject);

        connection.connect();

        result = connection.getResponseMessage()+"";
        Log.d("JSON Result:-   ",result);
        jsonresult.setText(result);


        return result;
    }

    private void setPostRequestcontect(HttpURLConnection connection, JSONObject jsonObject) throws IOException {

        OutputStream stream = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream,"UTF-8"));
        writer.write(jsonObject.toString());
        Log.i(com.example.dell.login_n_registration.Register.class.toString(),jsonObject.toString());
        writer.flush();
        writer.close();
        stream.close();
    }

    private JSONObject buildJsonObject() throws JSONException {

        JSONObject jsonObject = new JSONObject();

        jsonObject.accumulate("First Name",First_Name);
        jsonObject.accumulate("Last Name",Last_Name);
        jsonObject.accumulate("Gender",Gender);
        jsonObject.accumulate("Date Of Birth",DOB);
        jsonObject.accumulate("Mobile No.",Mobile_No);
        jsonObject.accumulate("Email ID",Email_ID);
        jsonObject.accumulate("Password",Password);
        jsonObject.accumulate("Flat No.",Flat_No);
        jsonObject.accumulate("Wing No.",Wing_No);
        jsonObject.accumulate("Address",Address);
        jsonObject.accumulate("Marital Status",Marital_Status);
        jsonObject.accumulate("Family Count",Fam_count);
        jsonObject.accumulate("Education",Education);
        jsonObject.accumulate("Occupation",Occupation);
        jsonObject.accumulate("Anniversary Date",Aniv_Date);

        return  jsonObject;
    }
}