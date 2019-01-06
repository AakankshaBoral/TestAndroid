package com.example.dell.trata_group_assignment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dell on 06-01-2019.
 */

class RecyclerTouchlistner implements RecyclerView.OnItemTouchListener {

    private GestureDetector gesturedetector;
    private ClickListener clicklistener;
    Context context;

    public RecyclerTouchlistner(Context applicationContext, final RecyclerView recyclerview,final ClickListener clickListener) {

        this.context = applicationContext;
        this.clicklistener = clickListener;
        gesturedetector = new GestureDetector(context, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

                View child = recyclerview.findChildViewUnder(e.getX(), e.getY());
                if (child != null && clickListener != null) {
                    clickListener.onLongClick(child,recyclerview.getChildLayoutPosition(child));

                }
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }

        });
    }



    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        View child = rv.findChildViewUnder(e.getX(), e.getY());
        if (child != null && clicklistener != null && gesturedetector.onTouchEvent(e)) {

            clicklistener.onClick(child,rv.getChildLayoutPosition(child));
        }
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


