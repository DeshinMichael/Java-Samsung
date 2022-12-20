package com.example.fiolesson;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText middleName;
    EditText surname;
    TextView members;
    Button btAdd;
    String members2 = "";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        middleName = findViewById(R.id.middlename);
        surname = findViewById(R.id.surname);
        members = findViewById(R.id.people);
        btAdd = findViewById(R.id.btAdd);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                People people1 = new People();
                people1.createNewPerson(surname.getText().toString() + " " + name.getText().toString() + " " + middleName.getText().toString());
                surname.setText("");
                name.setText("");
                middleName.setText("");
                members2 += people1.names2.get(0) + " " + people1.names2.get(1) + " " + people1.names2.get(2) + "\n";
                members.setText(members2);
            }
        });
    }
}