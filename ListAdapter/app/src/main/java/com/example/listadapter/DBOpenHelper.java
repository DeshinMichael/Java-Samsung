package com.example.listadapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    static final String DATABASE_FILENAME = "Library.db";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_TABLE = "Library";
    static final String COLUMNS_ID = "_id";
    static final String COLUMN_AUTHOR = "author";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_GENRE = "genre";
    static final String COLUMN_PAGES = "pages";

    public DBOpenHelper(@Nullable Context context) {
        super(context, DATABASE_FILENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DATABASE_TABLE + " (" +
                COLUMNS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_AUTHOR + " TEXT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_GENRE + " TEXT, " +
                COLUMN_PAGES + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
