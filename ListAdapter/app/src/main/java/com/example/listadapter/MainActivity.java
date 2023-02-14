package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<Book> booksList = new LinkedList<>();
    ListView listView;
    ArrayAdapter<Book> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.books_list);

        booksList.add(new Book("Тургенев И.С.","Отцы и дети", 150));
        booksList.add(new Book("Булгаков","Мастер и Маргарита", 240));
        booksList.add(new Book("Достоевский Ф.М.","Преступление и наказание", 320));
        booksList.add(new Book("Мелвилл Г.","Моби Дик", 210));
        booksList.add(new Book("Жюль Верн","Пятнадцатилетний капитан", 240));
        booksList.add(new Book("Карл Маркс","Капитал", 240));

        arrayAdapter = new ArrayAdapter<Book>(this, R.layout.list_item, booksList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), booksList.get(position).title, Toast.LENGTH_SHORT).show();
            }
        });
    }
}