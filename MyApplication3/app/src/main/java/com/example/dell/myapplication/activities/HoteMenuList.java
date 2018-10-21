package com.example.dell.myapplication.activities;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dell.myapplication.R;

import java.util.ArrayList;

public class HoteMenuList extends AppCompatActivity {

    RecyclerView reCyclerView;
    MenusAdapter adapter;
    ArrayList<Menus> menuslist = new ArrayList<>();
    Button back, order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hote_menu_list);
        fetchmenus();
    }

    private void fetchmenus() {

        menuslist.clear();

        DBAdapter db = new DBAdapter(this);
        db.openDB();

        Cursor c = db.getAllMenus();

        while (c.moveToNext()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            String price = c.getString(2);

            Menus m = new Menus(id, name, price);
            menuslist.add(m);
        }

        if (!(menuslist.size() < 1))
        {

            RecyclerView reCyclerView = (RecyclerView) findViewById(R.id.recyclerview);
            RecyclerView.LayoutManager layoutmanager = new LinearLayoutManager(getApplicationContext());
            reCyclerView.setLayoutManager(layoutmanager);
            reCyclerView.setItemAnimator(new DefaultItemAnimator());
            reCyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
            reCyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), reCyclerView, new RecyclerTouchListener.ClickListener() {
                @Override
                public void onClick(View view, int position) {

                    Menus menu = menuslist.get(position);
                    Toast.makeText(HoteMenuList.this,menu.getMenu()+" is Selected ",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onLongClick(View view, int position) {

                }
            }));

            adapter = new MenusAdapter(this,menuslist);
            reCyclerView.setAdapter(adapter);
        }

        db.closeDB();
    }

    public  void back(View view)
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void order(View view)
    {
        String url = "https://console.firebase.google.com/project/fir-example-152ba/notification";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}