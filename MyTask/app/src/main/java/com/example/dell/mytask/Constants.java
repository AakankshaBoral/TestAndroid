package com.example.dell.mytask;

/**
 * Created by dell on 02-08-2018.
 */

public class Constants {

    static final String ROW_ID = "id";
    static final String TASKNAME = "taskname";
    static final String DATE = "date";
    static final String TIME = "time";

    static final String DATABASE_NAME = "TASK_DB";
    static final String TABLE_NAME = "TASK_TABLE";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_TABLE = "CREATE TABLE TASK_TABLE(id INTEGER PRIMARY KEY AUTOINCREMENT,"+"taskname TEXT NOT NULL,date TEXT NOT NULL,time TEXT NOT NULL);";
}
