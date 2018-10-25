package com.example.dell.ecommerce_assignment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dell on 12-07-2018.
 */

class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder> {

    private List<Book> bookList;

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title,author,price;
        public MyViewHolder(View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            author = (TextView) itemView.findViewById(R.id.author);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }

    public BooksAdapter(List<Book> bookList) {

        this.bookList = bookList;
    }

    @Override
    public BooksAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new MyViewHolder(view);
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Book book = bookList.get(position);
        holder.title.setText(book.getTitle());
        holder.author.setText(book.getAuthor());
        holder.price.setText(book.getPrice());

    }



    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
