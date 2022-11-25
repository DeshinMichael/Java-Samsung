package com.example.bdayguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText nameEdit;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEdit = findViewById(R.id.editTextPersonName);
        datePicker = findViewById(R.id.datePicker);
    }

    public void onClick(View view) {
        String name = nameEdit.getText().toString();
        int date = datePicker.getDayOfMonth();
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("day", date);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
