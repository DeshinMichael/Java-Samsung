package com.example.clothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sdb;
    EditText cost, article, size, name, count;
    Button insertButton, showButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbOpenHelper = new DBOpenHelper(this);
        sdb = dbOpenHelper.getWritableDatabase();

        cost = findViewById(R.id.cost);
        article = findViewById(R.id.article);
        count = findViewById(R.id.count);
        name = findViewById(R.id.name);
        size = findViewById(R.id.size);
        insertButton = findViewById(R.id.insert_btn);
        showButton = findViewById(R.id.show_text);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put(DBOpenHelper.COLUMN_COST, cost.getText().toString());
                values.put(DBOpenHelper.COLUMN_ARTICLE, article.getText().toString());
                values.put(DBOpenHelper.COLUMN_NAME, name.getText().toString());
                values.put(DBOpenHelper.COLUMN_SIZE, size.getText().toString());
                values.put(DBOpenHelper.COLUMN_COUNT, Integer.parseInt(count.getText().toString()));
                sdb.insert(DBOpenHelper.DATABASE_TABLE, null, values);
                Toast.makeText(getApplicationContext(), "Данные сохранены", Toast.LENGTH_SHORT).show();
            }
        });
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DBInfoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        sdb = dbOpenHelper.getWritableDatabase();
    }

    @Override
    protected void onStop() {
        super.onStop();
        sdb.close();
    }
}