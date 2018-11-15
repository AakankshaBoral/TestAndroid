package com.example.dell.mytask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dell on 15-11-2018.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    Context context;
    ArrayList<Task> tasklist;
   // TextView tasktxt,datetxt,timetxt;

    public TaskAdapter(Context context, ArrayList<Task> tasklist) {

        this.context = context;
        this.tasklist = tasklist;

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView tasktxt,datetxt,timetxt;

        public MyViewHolder(View itemView) {
            super(itemView);

            tasktxt = (TextView) itemView.findViewById(R.id.tasktitle);
            datetxt = (TextView) itemView.findViewById(R.id.date);
            timetxt = (TextView) itemView.findViewById(R.id.Time);
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


        holder.tasktxt.setText(tasklist.get(position).getTaskname());
        holder.datetxt.setText(tasklist.get(position).getDate());
        holder.timetxt.setText(tasklist.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return tasklist.size();
    }
}
