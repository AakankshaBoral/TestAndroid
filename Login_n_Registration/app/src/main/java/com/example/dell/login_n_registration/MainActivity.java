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
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button login,register;
    EditText email,pass;
    String emailid,password;
    TextView connectivity,jsonresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (EditText) (findViewById(R.id.email_edittext)) ;
        pass = (EditText) (findViewById(R.id.password_edittext));

        login = (Button) (findViewById(R.id.login_button));
        register = (Button) (findViewById(R.id.resgister_button));

        connectivity = (TextView) findViewById(R.id.main_connectivity);
        jsonresult = (TextView) findViewById(R.id.main_jsonresulttextview);

        emailid = email.getText().toString();
        password = pass.getText().toString();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Register.class);
                startActivity(i);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email.setText("");
                pass.setText(" ");

                if (checkConnectivity())
                {
                    new HTTPAsycTask().execute("http://test.web.api.acorsociety.com/api/users/userloginasync");
                    Toast.makeText(getApplicationContext(),"Log In was Successful",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Error...Not Connected..",Toast.LENGTH_LONG).show();
                }

                ///checkConnectivity();
            }

        });

    }


    private boolean checkConnectivity() {

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isconnected = false;

        if (networkInfo != null && (isconnected = networkInfo.isConnected()))
        {
            connectivity.setText("Connected... "+networkInfo.getTypeName());
            Toast.makeText(this,"Connected....",Toast.LENGTH_LONG).show();
        }
        else
        {
            connectivity.setText("Not Connected");
            Toast.makeText(this,"Not Connected To Internet....",Toast.LENGTH_LONG).show();
        }

        return isconnected;
    }



    private class HTTPAsycTask extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... urls) {

            try {

                try {

                    return post(urls[0]);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    return "Username & Password doest not match...";
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
            //connectivity.setText(result);
        }
    }

    private String post(String jsonurl) throws IOException,JSONException {

        String result = "";

        URL url = new URL(jsonurl);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type","application/json;charset=utf-8");

        JSONObject jsonObject = buildJsonObject();
        setPostRequestcontect(connection,jsonObject);

        connection.connect();

        result = connection.getResponseMessage()+"";
        Log.d("JSON Result:-     ",result);
        jsonresult.setText(result);

        return result;
    }

    private void setPostRequestcontect(HttpURLConnection connection, JSONObject jsonObject) throws IOException {

        OutputStream stream = connection.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stream,"UTF-8"));
        writer.write(jsonObject.toString());
        Log.i(MainActivity.class.toString(),jsonObject.toString());
        writer.flush();
        writer.close();
        stream.close();

    }

    private JSONObject buildJsonObject() throws JSONException {

        JSONObject jsonObject = new JSONObject();
        jsonObject.accumulate("emailId",emailid);
        jsonObject.accumulate("password",password);
        return jsonObject;
    }
}


