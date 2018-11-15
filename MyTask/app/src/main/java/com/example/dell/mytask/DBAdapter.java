package com.example.dell.mytask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by dell on 01-08-2018.
 */

class DBAdapter extends SQLiteOpenHelper {

    Context context;
    //SQLiteDatabase db;
    DBHelper helper;


    public DBAdapter(Context context) {
        super(context,Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
        this.context = context;


    }

    /*public DBAdapter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    public DBAdapter openDB() {

        try
        {
           SQLiteDatabase db = this.getWritableDatabase();
            if(db.isOpen())
                Log.e(Constants.DATABASE_NAME," opened");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

        return this;
    }

    public Cursor getAllTasks() {

        SQLiteDatabase db = this.getWritableDatabase();
        String[] columns = new String[]{Constants.ROW_ID, Constants.TASKNAME, Constants.DATE,Constants.TIME};
        return db.query(Constants.TABLE_NAME,columns,null,null,null,null,null);
    }

    public void closeDB() {

        try
        {
            SQLiteDatabase db;
            this.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public long add(String taskname,String date,String time)
    {
        try
        {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Constants.TASKNAME,taskname);
            contentValues.put(Constants.DATE,date);
            contentValues.put(Constants.TIME,time);
            return  db.insert(Constants.TABLE_NAME,Constants.ROW_ID,contentValues);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {

            db.execSQL(Constants.CREATE_TABLE);
            Log.d("Created Table ",Constants.CREATE_TABLE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.d("Unable to create Table ",Constants.CREATE_TABLE);

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL("DROP TABLE IF EXITS " + Constants.TABLE_NAME);
            onCreate(db);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }



}
