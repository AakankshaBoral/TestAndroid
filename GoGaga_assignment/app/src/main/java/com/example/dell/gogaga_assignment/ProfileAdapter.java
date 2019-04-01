package com.example.dell.gogaga_assignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

/**
 * Created by dell on 01-04-2019.
 */

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.MyviewHolder> {

    private List<profile> profileList;

    public ProfileAdapter(List<profile> profileList)
    {
        this.profileList = profileList;
    }


    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView name,rank,points;
        CircularImageView imageView;

        public MyviewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name_recyclertextview);
            rank = (TextView) itemView.findViewById(R.id.rank_recyclertextview);
            points = (TextView) itemView.findViewById(R.id.points_recyclertextview);
            imageView = (CircularImageView) itemView.findViewById(R.id.circularimageview_recyclerimage);


        }
    }


    @Override
    public ProfileAdapter.MyviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new MyviewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProfileAdapter.MyviewHolder holder, int position) {

        profile pro_file = profileList.get(position);
        holder.rank.setText(pro_file.getRank());
        holder.name.setText(pro_file.getName());
        holder.points.setText(pro_file.getPoints());
        holder.imageView.setImageResource(pro_file.getProfile_pic());
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }


}
