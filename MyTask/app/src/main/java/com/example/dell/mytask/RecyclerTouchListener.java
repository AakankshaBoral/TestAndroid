package com.example.dell.mytask;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dell on 15-11-2018.
 */

class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {
    public RecyclerTouchListener(Context applicationContext, RecyclerView reCyclerView, ClickListener clickListener) {
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public  interface ClickListener {
        void onClick(View view, int position);
        void  onLongClick(View view, int position);
    }
}


