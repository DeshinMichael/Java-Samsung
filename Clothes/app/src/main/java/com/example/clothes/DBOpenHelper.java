package com.example.clothes;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenHelper extends SQLiteOpenHelper {

    //имя файла бд
    static final String DATABASE_FILENAME = "ClothesShop.db";
    static final int DATABASE_VERSION = 1;
    static final String DATABASE_TABLE = "Shop";
    static final String COLUMNS_ID = "_id";
    static final String COLUMN_COST = "cost";
    static final String COLUMN_SIZE = "size";
    static final String COLUMN_ARTICLE = "article";
    static final String COLUMN_NAME = "name";
    static final String COLUMN_COUNT = "count";

    public DBOpenHelper(@Nullable Context context) {
        super(context, DATABASE_FILENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + DATABASE_TABLE + " (" +
                COLUMNS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_COST + " TEXT, " +
                COLUMN_SIZE + " TEXT, " +
                COLUMN_ARTICLE + " TEXT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_COUNT + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
