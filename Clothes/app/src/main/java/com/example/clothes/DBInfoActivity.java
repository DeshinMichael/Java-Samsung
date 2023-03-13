package com.example.clothes;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class DBInfoActivity extends AppCompatActivity {
    ListView listView;
    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sdb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbinfo);

        listView = findViewById(R.id.db_info_list);

        dbOpenHelper = new DBOpenHelper(this);
        sdb = dbOpenHelper.getWritableDatabase();
        String query = "SELECT * FROM " + DBOpenHelper.DATABASE_TABLE + ";";
        Cursor cursor = sdb.rawQuery(query, null);
        if(cursor != null) {
            //Variant 1 - SimpleAdapter -> HashMap
            //Variant 2 - SimpleCursorAdapter
            String[] from = {DBOpenHelper.COLUMN_COST, DBOpenHelper.COLUMN_ARTICLE, DBOpenHelper.COLUMN_NAME,
                    DBOpenHelper.COLUMN_SIZE, DBOpenHelper.COLUMN_COUNT};
            int[] to = {R.id.cost_info, R.id.article_info, R.id.name_info, R.id.size_info, R.id.count_info};
            SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.list_item, cursor, from, to);
            listView.setAdapter(cursorAdapter);
        }
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