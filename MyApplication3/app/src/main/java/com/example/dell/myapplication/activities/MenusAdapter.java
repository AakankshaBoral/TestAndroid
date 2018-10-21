package com.example.dell.myapplication.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.myapplication.R;

import java.util.ArrayList;

/**
 * Created by dell on 31-07-2018.
 */

public class MenusAdapter extends RecyclerView.Adapter<MenusAdapter.MyViewHolder>{

    Context context;
    ArrayList<Menus> menulist;

    public MenusAdapter(Context context,ArrayList<Menus> menuslist) {

        this.context = context;
        this.menulist = menuslist;
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView menutxt,pricetxt;

        public MyViewHolder(View itemView) {
            super(itemView);

            menutxt = (TextView) itemView.findViewById(R.id.menuname);
            pricetxt = (TextView) itemView.findViewById(R.id.price);
        }



        @Override
        public void onClick(View v) {


        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.menutxt.setText( menulist.get(position).getMenu());
        holder.pricetxt.setText(menulist.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return menulist.size();
    }


}
