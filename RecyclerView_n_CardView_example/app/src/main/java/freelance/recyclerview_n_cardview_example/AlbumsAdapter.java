package freelance.recyclerview_n_cardview_example;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;

/**
 * Created by dell on 21-08-2017.
 */

class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;
    int [] images;
    public static MyClickListener clickListener;

    public AlbumsAdapter(MainActivity mContext, List<Album> albumList,int[] images) {

        this.mContext = mContext;
        this.albumList = albumList;
        this.images = images;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.album_card,parent,false);

        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.thumbnail.setImageResource(images[position]);
        holder.title.setText(album.getName());
        holder.count.setText(album.getNumOfSongs()+" Songs");
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showPopupMenu(holder.title);
            }
        });
    }

    private void showPopupMenu(View view) {

        PopupMenu popup = new PopupMenu(mContext,view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album,popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }



 /*    public void setOnItemClickListener(MyClickListener myClickListener) {

        this.clickListener = myClickListener;
    }*/


    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title,count;
        public ImageView thumbnail,overflow;
      // private MyClickListener clickListener;




        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            count = (TextView) itemView.findViewById(R.id.count);
            thumbnail = (ImageView) itemView.findViewById(R.id.thumbnail);
           // overflow = (ImageView) itemView.findViewById(R.id.overflow);
        }



       /* @Override
        public void onClick(View v) {

            clickListener.onItemClick(getAdapterPosition(),v);

        }*/
    }

    private class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId())
            {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext,"Added To Favourites",Toast.LENGTH_LONG).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext,"Playing...........",Toast.LENGTH_LONG).show();
                    return true;
                default:
            }
            return false;
        }
    }

   public interface MyClickListener
   {
       public void onItemClick(int position,View view);
   }
}
