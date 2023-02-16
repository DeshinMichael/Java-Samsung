package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {

    TextView tvTitle, tvAuthor, tvPages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        tvTitle = findViewById(R.id.item_title);
        tvAuthor = findViewById(R.id.item_author);
        tvPages = findViewById(R.id.item_pages);

        Bundle items = getIntent().getExtras();
        tvTitle.setText(items.get("title").toString());
        tvAuthor.setText(items.get("author").toString());
        tvPages.setText(items.get("numPages").toString());
    }
}