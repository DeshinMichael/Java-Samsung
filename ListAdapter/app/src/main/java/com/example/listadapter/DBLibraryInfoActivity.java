package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class DBLibraryInfoActivity extends AppCompatActivity {
    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sdb;
    ListView listLibrary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dblibrary_info);

        listLibrary = findViewById(R.id.list_library);

        dbOpenHelper = new DBOpenHelper(this);
        sdb = dbOpenHelper.getWritableDatabase();
        String query = "SELECT * FROM " + DBOpenHelper.DATABASE_TABLE + " ORDER BY " + DBOpenHelper.COLUMN_AUTHOR + ";";
        Cursor cursor = sdb.rawQuery(query, null);
        if(cursor != null){
            String[] from = {DBOpenHelper.COLUMN_AUTHOR, DBOpenHelper.COLUMN_NAME, DBOpenHelper.COLUMN_GENRE,
                    DBOpenHelper.COLUMN_PAGES};
            int[] to = {R.id.author_info, R.id.name_info, R.id.genre_info, R.id.pages_info};
            SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, from, to);
            listLibrary.setAdapter(cursorAdapter);
        }
//        String query = "SELECT " + DBOpenHelper.COLUMN_AUTHOR
//                + " FROM " + DBOpenHelper.DATABASE_TABLE + " ORDER BY "
//                + DBOpenHelper.COLUMN_AUTHOR + " ASC;";
//        Cursor cursor = sdb.rawQuery(query, null);
//        cursor.moveToFirst();
//        while(cursor.moveToNext()){
//            @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_AUTHOR));
//            tvAuthor.append("\n"+author+"\n");
//        }
//        cursor.close();
//
//        query = "SELECT " + DBOpenHelper.COLUMN_GENRE
//                + " FROM " + DBOpenHelper.DATABASE_TABLE + " ORDER BY "
//                + DBOpenHelper.COLUMN_GENRE + " ASC;";
//        cursor = sdb.rawQuery(query, null);
//        cursor.moveToFirst();
//        while(cursor.moveToNext()){
//            @SuppressLint("Range") String genre = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_GENRE));
//            tvGenre.append("\n"+genre+"\n");
//        }
//        cursor.close();
//
//        query = "SELECT " + DBOpenHelper.COLUMN_NAME
//                + ", " + DBOpenHelper.COLUMN_PAGES
//                + " FROM " + DBOpenHelper.DATABASE_TABLE + " ORDER BY "
//                + DBOpenHelper.COLUMN_NAME + " ASC;";
//        cursor = sdb.rawQuery(query, null);
//        cursor.moveToFirst();
//        while(cursor.moveToNext()){
//            @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME));
//            @SuppressLint("Range") int pages = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COLUMN_PAGES));
//            tvName.append("\n"+name+" "+pages+"стр."+"\n");
//        }
//        cursor.close();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!sdb.isOpen())
            sdb = dbOpenHelper.getWritableDatabase();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sdb.close();
    }
}