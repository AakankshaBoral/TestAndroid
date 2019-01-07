package freelance.recyclerview_n_cardview_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    //private int [] images = {R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6,R.drawable.album7,R.drawable.album8,R.drawable.album9,R.drawable.album10,R.drawable.album11,R.drawable.cover};
    int[] covers = new int[]{
            R.drawable.album1,
            R.drawable.album2,
            R.drawable.album3,
            R.drawable.album4,
            R.drawable.album5,
            R.drawable.album6,
            R.drawable.album7,
            R.drawable.album8,
            R.drawable.album9,
            R.drawable.album10,
            R.drawable.album11,
            R.drawable.cover
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this,albumList,covers);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
       recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Album album = albumList.get(position);
                Toast.makeText(getApplicationContext(),album.getName()+" Album is Selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
            /*  adapter.setOnItemClickListener(new AlbumsAdapter.MyClickListener() {
                  @Override
                  public void onItemClick(int position, View view) {
                      Album album = albumList.get(position);
                      Toast.makeText(getApplicationContext(),album.getName()+" Album is selected!",Toast.LENGTH_LONG).show();
                  }
              });*/


        prepareAlbums();
    }

    private void prepareAlbums() {


        Album a = new Album("True Romance",13,covers[0]);
        albumList.add(a);

        a = new Album("Xscpae",8,covers[1]);
        albumList.add(a);

        a = new Album("Maroon 5",11,covers[2]);
        albumList.add(a);

        a = new Album("Born To Die",12,covers[3]);
        albumList.add(a);

        a = new Album("HoneyMoon",14,covers[4]);
        albumList.add(a);

        a = new Album("I Need A Docter",1,covers[5]);
        albumList.add(a);

        a = new Album("Loud",11,covers[6]);
        albumList.add(a);

        a = new Album("Legends",14,covers[7]);
        albumList.add(a);

        a = new Album("One Dierection",11,covers[8]);
        albumList.add(a);

        a = new Album("Greatest Hits",17,covers[9]);
        albumList.add(a);

        a = new Album("One Call Away",1,covers[10]);
        albumList.add(a);

        a = new Album("Bryan Adams",10,covers[11]);
        albumList.add(a);

    }
}
