package freelance.recyclerview_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.view.ViewGroup;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerview;
    CustomAdapter adapter;
    int [] images = {R.drawable.united_states_of_america_icon,R.drawable.usaflag};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
        adapter = new CustomAdapter(this,images);
        RecyclerView.LayoutManager Im = new GridLayoutManager(this,2);
        recyclerview.setLayoutManager(Im);
        recyclerview.setAdapter(adapter);

    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Myviewholder>
    {
        Context mcontext;
        int [] images;

        public CustomAdapter(MainActivity mainActivity,int [] images)
        {
            this.mcontext = mainActivity;
            this.images = images;
        }



    class Myviewholder extends RecyclerView.ViewHolder
    {
        ImageView imageview;

        public Myviewholder(View itemView)
        {
            super(itemView);

            imageview=(ImageView)itemView.findViewById(R.id.imageview);

        }
    }

    public CustomAdapter.Myviewholder onCreateViewHolder(ViewGroup parent,int viewType)

    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new Myviewholder(v);

    }


public void onBindViewHolder(CustomAdapter.Myviewholder holder,int position)
{
    holder.imageview.setImageResource(images[position]);
}

public int getItemCount()
{
    return images.length;
}
}
}