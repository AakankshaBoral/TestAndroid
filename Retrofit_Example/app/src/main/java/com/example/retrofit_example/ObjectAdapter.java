package com.example.retrofit_example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ObjectAdapter extends RecyclerView.Adapter<ObjectAdapter.MyViewHolder>{


    private  MainActivity context;
    private  List<Information> infoList;





    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView userid = (TextView) itemView.findViewById(R.id.userid);
        TextView id = (TextView) itemView.findViewById(R.id.id);
        TextView title = (TextView) itemView.findViewById(R.id.title);
        TextView body = (TextView) itemView.findViewById(R.id.body);


        public MyViewHolder( View itemView) {

            super(itemView);



        }
    }

    public ObjectAdapter(Context mcontext, List<Information> infoList)
    {
        this.context = (MainActivity) mcontext;
        this.infoList = infoList;
    }

    @NonNull
    @Override
    public ObjectAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card,parent,false);
        return new MyViewHolder(itemview);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

       final int index = holder.getAdapterPosition();
        Information Infoobject = infoList.get(position);
         holder.itemView.findViewById(R.id.userid).setText(Infoobject.getUserid());
         holder.itemView.findViewById(R.id.id).setText(Infoobject.getId());
         holder.itemView.findViewById(R.id.title).setText(Infoobject.getTitle());
         holder.itemView.findViewById(R.id.body).setText(Infoobject.getBody());

    }

    @Override
    public int getItemCount() {
        return (infoList.size());
    }


}
