package com.example.lifecircle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.my_methods);

        text.append("Я родился!!!\n");
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        text.append("Я восстанавливаю!\n");
    }

    @Override
    protected void onStart() {
        super.onStart();
        text.append("Я стартую!\n");
        Toast.makeText(this,"Я стартую!",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        text.append("Я возобновляю!\n");
    }
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        text.append("Я сохраняю!\n");
    }

    @Override
    protected void onPause() {
        super.onPause();
        text.append("Я на паузе!\n");
    }

    @Override
    protected void onStop() {
        super.onStop();
        text.append("Я остановился!\n");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        text.append("Я перезапускаю!\n");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        text.append("Я сломался!\n");
    }
}