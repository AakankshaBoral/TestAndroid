package com.example.dell.ecommerce_assignment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected List<Book> bookList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BooksAdapter bAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        bAdapter = new BooksAdapter(bookList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(bAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),recyclerView, new RecyclerTouchListener.ClickListener() {

            public void onClick(View view, int position) {
                Book book = bookList.get(position);
                Toast.makeText(getApplicationContext(),book.getTitle()+" Book is Selected!",Toast.LENGTH_LONG).show();
            }


            public void onLongClick(View view, int position) {

            }
        }));

        insertBookData();

    }

    private void insertBookData() {

        Book book = new Book("Don't Loose Your Mind,Loose Your Weight","Rujuta Diwekar","200");
        bookList.add(book);

        book = new Book("Power Of Your Subconscious Mind","Dr Joseph Murphy","320");
        bookList.add(book);

        book = new Book("Think And Grow Rich","Napoleon Hill","400");
        bookList.add(book);

        book = new Book("The Diary Of Young Girl","Anne Frank","230");
        bookList.add(book);

        book = new Book("A Wasted Hour","Jeffery Archer","500");
        bookList.add(book);

        book = new Book("Think Straight:Change Your Thoughts,Change Your Life","Darius Foroux","560");
        bookList.add(book);

        book = new Book("Word Power Made Easy ","Norman Lewis","139");
        bookList.add(book);

        book = new Book("The Adventures Of Sherlock Holmes","Arthur Conan Doyle","300");
        bookList.add(book);

        book = new Book("Rich Dad,Poor Dad","Robert T Kiyosaki","249");
        bookList.add(book);

        book = new Book("Last Train To Istanbul","Ayse Kulin","259");
        bookList.add(book);

        book = new Book("Work Smarter Not Harder","Timo Kiander","450");
        bookList.add(book);

        book = new Book("Unhurried Tales:My Favourite Novellas","Ruskin Bond","589");
        bookList.add(book);

    }
}
