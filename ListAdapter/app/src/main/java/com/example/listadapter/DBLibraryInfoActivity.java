package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class DBLibraryInfoActivity extends AppCompatActivity {
    TextView tvAuthor, tvGenre, tvName;
    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dblibrary_info);

        tvAuthor = findViewById(R.id.author_info);
        tvGenre = findViewById(R.id.genre_info);
        tvName = findViewById(R.id.name_info);

        dbOpenHelper = new DBOpenHelper(this);
        sdb = dbOpenHelper.getWritableDatabase();

        String query = "SELECT " + DBOpenHelper.COLUMN_AUTHOR
                + " FROM " + DBOpenHelper.DATABASE_TABLE + " ORDER BY "
                + DBOpenHelper.COLUMN_AUTHOR + " ASC;";
        Cursor cursor = sdb.rawQuery(query, null);
        cursor.moveToFirst();
        while(cursor.moveToNext()){
            @SuppressLint("Range") String author = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_AUTHOR));
            tvAuthor.append(author+"\n");
        }
        cursor.close();

        query = "SELECT " + DBOpenHelper.COLUMN_GENRE
                + " FROM " + DBOpenHelper.DATABASE_TABLE + " ORDER BY "
                + DBOpenHelper.COLUMN_GENRE + " ASC;";
        Cursor cursor2 = sdb.rawQuery(query, null);
        cursor2.moveToFirst();
        while(cursor2.moveToNext()){
            @SuppressLint("Range") String genre = cursor2.getString(cursor2.getColumnIndex(DBOpenHelper.COLUMN_GENRE));
            tvAuthor.append(genre+"\n");
        }
        cursor2.close();

        query = "SELECT " + DBOpenHelper.COLUMN_NAME
                + " FROM " + DBOpenHelper.DATABASE_TABLE + " ORDER BY "
                + DBOpenHelper.COLUMN_NAME + " ASC;";
        Cursor cursor3 = sdb.rawQuery(query, null);
        cursor3.moveToFirst();
        while(cursor3.moveToNext()){
            @SuppressLint("Range") String name = cursor3.getString(cursor3.getColumnIndex(DBOpenHelper.COLUMN_NAME));
            tvAuthor.append(name+"\n");
        }
        cursor3.close();
    }
}