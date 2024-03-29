package com.example.listadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    Button btShowLibrary, btnSave;
    EditText etAuthor, etName, etGenre, etPages;
//    TreeSet<Book> booksTreeSet = new TreeSet<>();

    //список книг под SimpleAdapter
    LinkedList<HashMap<String, Object>> adapterListBooks = new LinkedList<>();

    //SharedPreferences
//    SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;
//    TextView readBook;
    //DataBase
    DBOpenHelper dbOpenHelper;
    SQLiteDatabase sdb;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbOpenHelper = new DBOpenHelper(this);
        sdb = dbOpenHelper.getWritableDatabase();
//        sharedPreferences = getSharedPreferences("myShared", MODE_PRIVATE);

        listView = findViewById(R.id.books_list);
        btShowLibrary = findViewById(R.id.show_library);
        btnSave = findViewById(R.id.btn_save);
        etAuthor = findViewById(R.id.et_author);
        etName = findViewById(R.id.et_name);
        etGenre = findViewById(R.id.et_genre);
        etPages = findViewById(R.id.et_pages);
//        readBook = findViewById(R.id.read_book);

//        booksList.add(new Book("Азимов А.","Основание", 150, R.drawable.osnovanie));
//        booksList.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.shinel));
//        booksList.add(new Book("Достоевский Ф.М.","Преступление и наказание", 320, R.drawable.prestuplenie));
//        booksList.add(new Book("Гоглоев Евгений","Зерцалия", 210, R.drawable.zertsalia));
//        booksList.add(new Book("Жюль Верн","Пятнадцатилетний капитан", 240, R.drawable.book));
//        booksList.add(new Book("Карл Маркс","Капитал", 240, R.drawable.book));
//        booksList.add(new Book("Гоголь Н.","Мёртвые души", 240, R.drawable.book));
//        booksList.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.book));
//        booksList.add(new Book("Гоголь Н.","Ревизор", 240, R.drawable.book));
//        booksList.add(new Book("Гоголь Н.","Тарас Бульба", 240, R.drawable.book));
//        booksList.add(new Book("Достоевский Ф.М.","Белые ночи", 240, R.drawable.book));
//        booksList.add(new Book("Гоголь Н.","Невский проспект", 240, R.drawable.book));
//        booksList.add(new Book("Достоевский Ф.М.","Идиот", 240, R.drawable.book));
//        booksList.add(new Book("Достоевский Ф.М.","Бедные люди", 240, R.drawable.book));
//        booksList.add(new Book("Толстой Л.Н.","Война и мир", 240, R.drawable.book));

//        booksTreeSet.add(new Book("Азимов А.","Основание", 150, R.drawable.osnovanie));
//        booksTreeSet.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.shinel));
//        booksTreeSet.add(new Book("Достоевский Ф.М.","Преступление и наказание", 320, R.drawable.prestuplenie));
//        booksTreeSet.add(new Book("Гоглоев Евгений","Зерцалия", 210, R.drawable.zertsalia));
//        booksTreeSet.add(new Book("Жюль Верн","Пятнадцатилетний капитан", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Карл Маркс","Капитал", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Гоголь Н.","Мёртвые души", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Гоголь Н.","Шинель", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Гоголь Н.","Ревизор", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Гоголь Н.","Тарас Бульба", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Достоевский Ф.М.","Белые ночи", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Гоголь Н.","Невский проспект", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Достоевский Ф.М.","Идиот", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Достоевский Ф.М.","Бедные люди", 240, R.drawable.book));
//        booksTreeSet.add(new Book("Толстой Л.Н.","Война и мир", 240, R.drawable.book));

//        //готовим список для адаптера
//        for (int i = 0; i < booksList.size(); i++) {
//            HashMap<String, Object> map = new HashMap<>();
//            map.put("author", booksList.get(i).author);
//            map.put("title", booksList.get(i).title);
//            map.put("numpage", booksList.get(i).numPages);
//            map.put("cover", booksList.get(i).cover);
//            adapterListBooks.add(map);
//        }
//
//        //Массив ключей
//        String[] from = {"author", "title", "numpage", "cover"};
//        //Массив идентификаторов разметки
//        int[] to = {R.id.author, R.id.title_book, R.id.numpage, R.id.cover};
//
//        arrayAdapter = new ArrayAdapter<Book>(this, R.layout.list_item, booksList);
//
//        simpleAdapter = new SimpleAdapter(this, adapterListBooks, R.layout.list_item_simple, from, to);
//        listView.setAdapter(simpleAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(MainActivity.this, ItemActivity.class);
//                intent.putExtra("title", booksList.get(position).title);
//                intent.putExtra("author", booksList.get(position).author);
//                intent.putExtra("numPages", booksList.get(position).numPages);
//                startActivity(intent);
//                //arrayAdapter.notifyDataSetChanged();
////                editor = sharedPreferences.edit();
////                editor.putString("book" + position, booksList.get(position).toString());
////                editor.commit();
//            }
//        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(DBOpenHelper.COLUMN_AUTHOR, etAuthor.getText().toString());
                values.put(DBOpenHelper.COLUMN_NAME, etName.getText().toString());
                values.put(DBOpenHelper.COLUMN_GENRE, etGenre.getText().toString());
                values.put(DBOpenHelper.COLUMN_PAGES, Integer.parseInt(etPages.getText().toString()));
                sdb.insert(DBOpenHelper.DATABASE_TABLE, null, values);
                Toast.makeText(getApplicationContext(), "Книга сохранена", Toast.LENGTH_SHORT).show();
                etAuthor.setText("");
                etName.setText("");
                etGenre.setText("");
                etPages.setText("");
//                adapterListBooks.clear();
//
//                List<Book> list = new ArrayList<>();
//                for (Book book : booksList){
//                    if(book.author.equals(etSearch.getText().toString())){
//                        list.add(book);
//                    }
//                }
//
//                for (int i = 0; i < list.size(); i++) {
//                    HashMap<String, Object> map = new HashMap<>();
//                    map.put("author", list.get(i).author);
//                    map.put("title", list.get(i).title);
//                    map.put("numpage", list.get(i).numPages);
//                    map.put("cover", list.get(i).cover);
//                    adapterListBooks.add(map);
//                }
//
//                //Массив ключей
//                String[] from = {"author", "title", "numpage", "cover"};
//                //Массив идентификаторов разметки
//                int[] to = {R.id.author, R.id.title_book, R.id.numpage, R.id.cover};
//
//                arrayAdapter = new ArrayAdapter<Book>(MainActivity.this, R.layout.list_item, booksList);
//
//                simpleAdapter = new SimpleAdapter(MainActivity.this, adapterListBooks, R.layout.list_item_simple, from, to);
//                listView.setAdapter(simpleAdapter);
            }
        });

        btShowLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DBLibraryInfoActivity.class);
                startActivity(intent);
//                adapterListBooks.clear();

//                List<Book> list = new ArrayList<>(booksList);
//
//                for (int i = 0; i < list.size(); i++) {
//                    HashMap<String, Object> map = new HashMap<>();
//                    map.put("author", list.get(i).author);
//                    map.put("title", list.get(i).title);
//                    map.put("numpage", list.get(i).numPages);
//                    map.put("cover", list.get(i).cover);
//                    adapterListBooks.add(map);
//                }
//
//                //Массив ключей
//                String[] from = {"author", "title", "numpage", "cover"};
//                //Массив идентификаторов разметки
//                int[] to = {R.id.author, R.id.title_book, R.id.numpage, R.id.cover};
//
//                arrayAdapter = new ArrayAdapter<Book>(MainActivity.this, R.layout.list_item, booksList);
//
//                simpleAdapter = new SimpleAdapter(MainActivity.this, adapterListBooks, R.layout.list_item_simple, from, to);
//                listView.setAdapter(simpleAdapter);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(!sdb.isOpen())
            sdb = dbOpenHelper.getWritableDatabase();
//        //извлечение 1 записи по конкретному ключу
//        String s = sharedPreferences.getString("book", "Не читал ничего");
//        readBook.setText(s);
//        //извлечение всех данных
//        Map<String, ?> sharedTreeMap = sharedPreferences.getAll();
//        Collection<?> set = sharedTreeMap.values();
//        Iterator<?> iterator = set.iterator();
//        while(iterator.hasNext()) {
//            s = iterator.next().toString() + "\n\n";
//            readBook.append(s);
//        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sdb.close();
    }
}
