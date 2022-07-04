package com.example.retrofit_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        

        getInfo();
    }

    private void getInfo() {

        Call<List<Information>> call = RetrofitClient.getInstance().getMyApi().getInfo();
        call.enqueue(new Callback<List<Information>>() {
            public void onResponse(Call<List<Information>> call, Response<List<Information>> response) {

                List<Information> objectList = response.body();


                String[] userid = new String[objectList.size()];
                String[] id = new String[objectList.size()];
                String[] title = new String[objectList.size()];
                String[] body = new String[objectList.size()];




                for (int i = 0; i < objectList.size(); i++) {
                    userid[i] = objectList.get(i).getUserid();
                    id[i] = objectList.get(i).getId();
                    title[i] = objectList.get(i).getTitle();
                    body[i] = objectList.get(i).getBody();
                }

                RecyclerView recyclerView = findViewById(R.id.recyclerview);

                ObjectAdapter adapter = new ObjectAdapter(getApplicationContext(),objectList);
                RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Information>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

            }




        });
    }
    }




