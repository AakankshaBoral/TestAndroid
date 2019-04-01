package com.example.dell.gogaga_assignment;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CircularImageView circularImageView;
    protected List<profile> profileList = new ArrayList<>();
    private ProfileAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        adapter = new ProfileAdapter(profileList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);

        prepareprofiledata();
    }

    private void prepareprofiledata() {


         profile pro_file = new profile("1",R.drawable.trophy,"Sarthak","1600");
         profileList.add(pro_file);

         pro_file = new profile("2",R.drawable.trophy,"Meet","9390");
         profileList.add(pro_file);

         pro_file = new profile("3",R.drawable.trophy,"Ashustosh","8940");
         profileList.add(pro_file);

         pro_file = new profile("4",R.drawable.trophy,"Sourabh","8800");
         profileList.add(pro_file);

         pro_file = new profile("5",R.drawable.trophy,"Neha","8315");
         profileList.add(pro_file);

    }
}
