package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String mylog = "User12345";
    String mypass = "qwerty12345";
    EditText login;
    EditText password;
    Button signin;
    TextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.signin);
        check = findViewById(R.id.check);
    }

    @SuppressLint("ResourceAsColor")
    public void signIn(View view) {
        if(login.getText().toString().equals(mylog) && password.getText().toString().equals(mypass)) {
            check.setText("Верно");
            check.setTextColor(Color.GREEN);
        } else {
            check.setText("Вы ошиблись в логине или пароле");
            check.setTextColor(Color.RED);
            login.setText("");
            password.setText("");
        }
    }
}
