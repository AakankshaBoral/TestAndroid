package com.example.navigationdrawer_assignment.ui.home;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.navigationdrawer_assignment.R;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView recyclerView1,recyclerView2;
    VideoView videoView;
    CardView cardView;
    private AlbumAdaptar1 adapter1;
    private AlbumAdapter2 adapter2;
    private List<Album> albumList1;
    private List<Album> albumList2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
       /* final TextView textView = root.findViewById(R.id.text_courses);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        videoView = root.findViewById(R.id.cardvideoview);

        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("https://www.youtube.com/watch?v=lL2PXC1fmnQ");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        recyclerView1 = root.findViewById(R.id.recyclerview1);
        recyclerView2 = root.findViewById(R.id.recyclerview2);

        albumList1 = new ArrayList<>();
        adapter1 = new AlbumAdaptar1(getContext(),albumList1);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,true);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setAdapter(adapter1);
        recyclerView1.addItemDecoration(new CardItemDecoration(2,10,true));
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        albumList2 = new ArrayList<>();
        adapter2 = new AlbumAdapter2(getContext(),albumList2);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,true);
        recyclerView2.setLayoutManager(layoutManager2);
        recyclerView2.setAdapter(adapter2);
        recyclerView2.addItemDecoration(new CardItemDecoration(2,10,true));
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        preparecourselist1();
        preparecourselist2();

        return root;


    }

    private void preparecourselist2() {

        Album a = new Album("Java-Session 06-Java Hello World Explanation");
        albumList2.add(a);

    }

    private void preparecourselist1()
    {
        Album a = new Album("Java-Session 01-Introduction to Java");
        albumList1.add(a);

        a = new Album("Java-Session 02-Java History");
        albumList1.add(a);

        a = new Album("Java-Session 03-Java Features");
        albumList1.add(a);

        a = new Album("Java-Session 04-Java Installation");
        albumList1.add(a);

        a = new Album("Java-Session 05-Java Hello World");
        albumList1.add(a);
    }


}
