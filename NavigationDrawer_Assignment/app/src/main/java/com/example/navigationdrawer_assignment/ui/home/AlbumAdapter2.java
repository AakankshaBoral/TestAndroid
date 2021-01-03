package com.example.navigationdrawer_assignment.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.navigationdrawer_assignment.R;
import java.util.List;

public class AlbumAdapter2 extends RecyclerView.Adapter<AlbumAdapter2.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList2;
    public static MyClickListener clickListener;

    public AlbumAdapter2(Context context, List<Album> albumList2) {
        this.mContext = context;
        this.albumList2 = albumList2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Album album = albumList2.get(position);
        holder.title.setText(album.getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }

    @Override
    public int getItemCount() {
         return albumList2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        // private MyClickListener clickListener;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.cardlayout_textview);
        }
    }

    public interface MyClickListener
    {
        public void onItemClick(int position,View view);
    }
}
