package com.example.filesexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainActivity extends AppCompatActivity {
    EditText infoText;
    Button saveButton, loadButton;
    TextView loadText;
    final String FILENAME = "money.txt";
    String[] array;
    boolean isWent = false;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoText = findViewById(R.id.info_text);
        saveButton = findViewById(R.id.save_btn);
        loadButton = findViewById(R.id.load_btn);
        loadText = findViewById(R.id.load_text);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                            openFileOutput(FILENAME, MODE_APPEND)));
                    bw.write(infoText.getText().toString());
                    bw.write("\n");
                    bw.close();
                    String str = "";
                    str += infoText.getText().toString() + " ";
                    array = str.split(" ");
                    if (array.length > 0)
                        isWent = true;
                    infoText.setText("");
                } catch (FileNotFoundException e) {
                    loadText.setText("Невозможно сохранить. Файл не найден");
                } catch (IOException e) {
                    loadText.setText("Ошибка записи");
                }
            }
        });
        loadButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                try {
                    if (!isWent) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(
                                openFileInput(FILENAME)));
                        String s = br.readLine();
                        while (s != null) {
                            loadText.append(s);
                            s = br.readLine();
                            loadText.append("\n");
                        }
                        br.close();
                    } else {
                        for (String s : array) {
                            loadText.append(s);
                            loadText.append("\n");
                        }
                    }
                } catch (FileNotFoundException e) {
                    loadText.setText("Невозможно сохранить. Файл не найден");
                } catch (IOException e) {
                    loadText.setText("Ошибка чтения");
                }
            }
        });
    }
}