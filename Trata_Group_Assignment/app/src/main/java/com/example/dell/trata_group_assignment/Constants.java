package com.example.dell.trata_group_assignment;

/**
 * Created by dell on 02-08-2018.
 */

public class Constants {

    static final String ROW_ID = "id";
    static final String FIRSTNAME = "firstname";
    static final String LASTNAME = "lastname";
    static final String DATEOFBIRTH = "dateofbirth";
    static final String GENDER = "gender";

    static final String DATABASE_NAME = "PERSONAL_DETAILS_DB";
    static final String TABLE_NAME = "DETAIL_TABLE";
    static final int DATABASE_VERSION = 1;
    static final String CREATE_TABLE = "CREATE TABLE DETAIL_TABLE(id INTEGER PRIMARY KEY AUTOINCREMENT,"+"firstname TEXT NOT NULL,lastname TEXT NOT NULL,dateofbirth TEXT NOT NULL,gender TEXT NOT NULL);";
}
