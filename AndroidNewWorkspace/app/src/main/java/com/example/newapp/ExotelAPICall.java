package com.example.newapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ExotelAPICall extends AppCompatActivity {

    public static String mobilenumber = "your-customer-number";
    public static String url = "http://my.exotel.com/";
    public static String accountSid = "your-exotel-account-sid";
    public static String flow_id = "your-flow-id";
    public static String api_key = "your-API-Key";
    public static String api_token = "your-API-Token";

   /// public ExotelResponse res = new ExotelResponse();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exotel_a_p_i_call);




    }
}
