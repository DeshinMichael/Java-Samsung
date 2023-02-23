package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    LinkedList<Book> booksList = new LinkedList<>();//исходный список книг
    ListView listView;
    ArrayAdapter<Book> arrayAdapter;
    SimpleAdapter simpleAdapter;
    Button btShowAll, btnSearch;
    EditText etSearch;
    Set<Book> booksTreeSet = new TreeSet<>();

    //список книг под SimpleAdapter
    LinkedList<HashMap<String, Object>> adapterListBooks = new LinkedList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.books_list);
        btShowAll = findViewById(R.id.show_all_books);
        btnSearch = findViewById(R.id.btn_search);
        etSearch = findViewById(R.id.et_search);

        booksList.add(new Book("Азимов А.","Основание", 150, R.drawable.osnovanie));
        booksList.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.shinel));
        booksList.add(new Book("Достоевский Ф.М.","Преступление и наказание", 320, R.drawable.prestuplenie));
        booksList.add(new Book("Гоглоев Евгений","Зерцалия", 210, R.drawable.zertsalia));
        booksList.add(new Book("Жюль Верн","Пятнадцатилетний капитан", 240, R.drawable.book));
        booksList.add(new Book("Карл Маркс","Капитал", 240, R.drawable.book));
        booksList.add(new Book("Гоголь Н.","Мёртвые души", 240, R.drawable.book));
        booksList.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.book));
        booksList.add(new Book("Гоголь Н.","Ревизор", 240, R.drawable.book));
        booksList.add(new Book("Гоголь Н.","Тарас Бульба", 240, R.drawable.book));
        booksList.add(new Book("Достоевский Ф.М.","Белые ночи", 240, R.drawable.book));
        booksList.add(new Book("Гоголь Н.","Невский проспект", 240, R.drawable.book));
        booksList.add(new Book("Достоевский Ф.М.","Идиот", 240, R.drawable.book));
        booksList.add(new Book("Достоевский Ф.М.","Бедные люди", 240, R.drawable.book));
        booksList.add(new Book("Толстой Л.Н.","Война и мир", 240, R.drawable.book));

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

        booksTreeSet.add(new Book("Азимов А.","Основание", 150, R.drawable.osnovanie));
        booksTreeSet.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.shinel));
        booksTreeSet.add(new Book("Достоевский Ф.М.","Преступление и наказание", 320, R.drawable.prestuplenie));
        booksTreeSet.add(new Book("Гоглоев Евгений","Зерцалия", 210, R.drawable.zertsalia));
        booksTreeSet.add(new Book("Жюль Верн","Пятнадцатилетний капитан", 240, R.drawable.book));
        booksTreeSet.add(new Book("Карл Маркс","Капитал", 240, R.drawable.book));
        booksTreeSet.add(new Book("Гоголь Н.","Мёртвые души", 240, R.drawable.book));
        booksTreeSet.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.book));
        booksTreeSet.add(new Book("Гоголь Н.","Ревизор", 240, R.drawable.book));
        booksTreeSet.add(new Book("Гоголь Н.","Тарас Бульба", 240, R.drawable.book));
        booksTreeSet.add(new Book("Достоевский Ф.М.","Белые ночи", 240, R.drawable.book));
        booksTreeSet.add(new Book("Гоголь Н.","Невский проспект", 240, R.drawable.book));
        booksTreeSet.add(new Book("Достоевский Ф.М.","Идиот", 240, R.drawable.book));
        booksTreeSet.add(new Book("Достоевский Ф.М.","Бедные люди", 240, R.drawable.book));
        booksTreeSet.add(new Book("Толстой Л.Н.","Война и мир", 240, R.drawable.book));

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

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Iterator<Book> iterator = booksTreeSet.iterator();
                while(iterator.hasNext()){
                    if(!(iterator.next().author.equals(etSearch.getText().toString()))){
                        booksList.remove(iterator.next());
                    }
                }
            }
        });
    }
}