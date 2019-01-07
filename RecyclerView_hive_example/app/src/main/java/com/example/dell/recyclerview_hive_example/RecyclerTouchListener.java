package com.example.dell.recyclerview_hive_example;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;


public class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

    private Context context;
    private GestureDetector gestureDetector;
    private ClickListener clickListener;


    public RecyclerTouchListener(Context context, final RecyclerView recyclerView,final ClickListener clickListener)
    {
        this.context = context;
        this.clickListener = clickListener;
        gestureDetector = new GestureDetector(context, new GestureDetector.OnGestureListener() {
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

                View child = recyclerView.findChildViewUnder(e.getX(),e.getY());
                if (child!=null && clickListener!=null)
                {
                    clickListener.onLongClick(child,recyclerView.getChildLayoutPosition(child));

                }
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                return false;
            }
        });


    }
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e)
    {
        View child = rv.findChildViewUnder(e.getX(),e.getY());
          if (child!=null && clickListener!=null && gestureDetector.onTouchEvent(e))
          {
              clickListener.onClick(child,rv.getChildLayoutPosition(child));
          }
           return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }

    public interface ClickListener {
         void onClick(View view, int position);
         void  onLongClick(View view, int position);
    }
}
