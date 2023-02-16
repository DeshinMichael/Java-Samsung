package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    LinkedList<Book> booksList = new LinkedList<>();//исходный список книг
    ListView listView;
    ArrayAdapter<Book> arrayAdapter;
    SimpleAdapter simpleAdapter;

    //список книг под SimpleAdapter
    LinkedList<HashMap<String, Object>> adapterListBooks = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.books_list);

        booksList.add(new Book("Азимов А.","Основание", 150, R.drawable.osnovanie));
        booksList.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.shinel));
        booksList.add(new Book("Достоевский Ф.М.","Преступление и наказание", 320, R.drawable.prestuplenie));
        booksList.add(new Book("Гоглоев Евгений","Зерцалия", 210, R.drawable.zertsalia));
        booksList.add(new Book("Жюль Верн","Пятнадцатилетний капитан", 240, R.drawable.book));
        booksList.add(new Book("Карл Маркс","Капитал", 240, R.drawable.book));

        //готовим список для адаптера
        for (int i = 0; i < booksList.size(); i++) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("author", booksList.get(i).author);
            map.put("title", booksList.get(i).title);
            map.put("numpage", booksList.get(i).numPages);
            map.put("cover", booksList.get(i).cover);
            adapterListBooks.add(map);
        }

        //Массив ключей
        String[] from = {"author", "title", "numpage", "cover"};
        //Массив идентификаторов разметки
        int[] to = {R.id.author, R.id.title_book, R.id.numpage, R.id.cover};

        arrayAdapter = new ArrayAdapter<Book>(this, R.layout.list_item, booksList);

        simpleAdapter = new SimpleAdapter(this, adapterListBooks, R.layout.list_item_simple, from, to);
        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
                intent.putExtra("title", booksList.get(position).title);
                intent.putExtra("author", booksList.get(position).author);
                intent.putExtra("numPages", booksList.get(position).numPages);
                startActivity(intent);
                //arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}