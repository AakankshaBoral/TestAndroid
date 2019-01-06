package com.example.dell.trata_group_assignment;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by dell on 02-08-2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DBHelper(Context context)
    {
        super(context,Constants.DATABASE_NAME, null,Constants.DATABASE_VERSION);
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
