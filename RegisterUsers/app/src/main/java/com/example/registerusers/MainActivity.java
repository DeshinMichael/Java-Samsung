package com.example.registerusers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    TextView title, users;
    EditText etLogin, etPassword;
    Button btnSignUp, btnBack, btnSignIn;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("myShared", MODE_PRIVATE);

        title = findViewById(R.id.title);
        etLogin = findViewById(R.id.et_login);
        etPassword = findViewById(R.id.et_password);
        btnSignUp = findViewById(R.id.btn_sign_up);
        btnBack = findViewById(R.id.btn_back);
        users = findViewById(R.id.users);
        btnSignIn = findViewById(R.id.btn_sign_in);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etLogin.getText().toString().equals("")
                &&!etPassword.getText().toString().equals("")
                &&!sharedPreferences.contains(String.valueOf(etPassword.getText().toString().hashCode()))){
                    editor = sharedPreferences.edit();
                    editor.putString(String.valueOf(etPassword.getText().toString().hashCode()),
                            etLogin.getText().toString());
                    editor.commit();
                }
                btnSignUp.setVisibility(View.GONE);
                btnSignIn.setVisibility(View.VISIBLE);
                etLogin.setText("");
                etPassword.setText("");
                title.setText("Авторизация");
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, ?> sharedTreeMap = sharedPreferences.getAll();
                if(sharedTreeMap.containsKey(String.valueOf(etPassword.getText().toString().hashCode()))){
                    users.setText("Вы вошли под логином " + etLogin.getText().toString());
                }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title.setText("Регистрация");
                etLogin.setText("");
                etPassword.setText("");
                btnSignUp.setVisibility(View.VISIBLE);
                btnSignIn.setVisibility(View.GONE);
                users.setText("");
            }
        });
    }
}