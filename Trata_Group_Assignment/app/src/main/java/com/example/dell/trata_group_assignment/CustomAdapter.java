package com.example.dell.trata_group_assignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 06-01-2019.
 */

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    Context context;
    ArrayList<Personal_Details> detailslist;
  //  LayoutInflater inflater;
    //Details details;

    public CustomAdapter(Context context, ArrayList<Personal_Details> detailslist) {
        this.context = context;
        this.detailslist = detailslist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,null);
        MyViewHolder holder = new MyViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.firstname.setText(detailslist.get(position).getFirst_name());
        holder.lastname.setText(detailslist.get(position).getLast_name());
        holder.dob.setText(detailslist.get(position).getDate_of_birth());
        holder.gender.setText(detailslist.get(position).getGender());

    }

    @Override
    public int getItemCount() {
        return detailslist.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

       TextView firstname,lastname,dob,gender;

        public MyViewHolder(View itemView) {
            super(itemView);

            firstname = (TextView) itemView.findViewById(R.id.firstname_recycler_textview);
            lastname = (TextView) itemView.findViewById(R.id.lastname_recycler_textview);
            dob = (TextView) itemView.findViewById(R.id.dob_recycler_textview);
            gender = (TextView)itemView.findViewById(R.id.gender_recycler_textview);

        }

        @Override
        public void onClick(View v) {


        }
    }
}
