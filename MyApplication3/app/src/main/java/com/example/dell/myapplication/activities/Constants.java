package com.example.dell.myapplication.activities;

/**
 * Created by dell on 02-08-2018.
 */

public class Constants {

    static final String ROW_ID = "id";
    static final String MENUNAME = "menuname";
    static final String PRICE = "price";

    static final String DATABASE_NAME = "HOTEL_DB";
    static final String TABLE_NAME = "HOTEL_TABLE";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_TABLE = "CREATE TABLE HOTEL_TABLE(id INTEGER PRIMARY KEY AUTOINCREMENT,"+"menuname TEXT NOT NULL,price TEXT NOT NULL);";
}
