package com.example.navigationdrawer_assignment.ui.home;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.navigationdrawer_assignment.MainActivity;
import com.example.navigationdrawer_assignment.R;
import java.util.List;



public class AlbumAdaptar1 extends RecyclerView.Adapter<AlbumAdaptar1.MyViewHolder>
 {
     private Context mContext;
     private List<Album> albumList;
     public static MyClickListener clickListener;


     public AlbumAdaptar1(Context context, List<Album> albumList) {

         this.mContext = context;
         this.albumList = albumList;

     }


     @NonNull
     @Override
     public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
         return new MyViewHolder(view);
     }

     @Override
     public void onBindViewHolder(final MyViewHolder holder, int position) {

         Album album = albumList.get(position);
         holder.title.setText(album.getTitle());
         holder.title.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {


             }
         });
     }



     @Override
     public int getItemCount() {
         return albumList.size();
     }

     public class MyViewHolder extends RecyclerView.ViewHolder {
         public TextView title;
         // private MyClickListener clickListener;
         public MyViewHolder(View itemView) {
             super(itemView);
           //  count = (TextView) itemView.findViewById(R.id.count);
             title = (TextView) itemView.findViewById(R.id.cardlayout_textview);
     }
     }

     public interface MyClickListener
     {
         public void onItemClick(int position,View view);
     }

     public class cardItemdecoration extends RecyclerView.ItemDecoration
     {
         private int spanCount;
         private int spacing;
         private boolean includeEdge;

         public cardItemdecoration(int spanCount, int spacing, boolean includeEdge) {
             this.spanCount = spanCount;
             this.spacing = spacing;
             this.includeEdge = includeEdge;
         }

         @Override
         public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
             super.getItemOffsets(outRect, view, parent, state);

             int position = parent.getChildAdapterPosition(view); // item position
             int column = position % spanCount; // item column

             if (includeEdge) {
                 outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                 outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                 if (position < spanCount) { // top edge
                     outRect.top = spacing;
                 }
                 outRect.bottom = spacing; // item bottom
             } else {
                 outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                 outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                 if (position >= spanCount) {
                     outRect.top = spacing; // item top
                 }
             }
         }
         }

     private int dpToPx(int dp) {
         Resources r = Resources.getSystem();
         return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
     }
     }

