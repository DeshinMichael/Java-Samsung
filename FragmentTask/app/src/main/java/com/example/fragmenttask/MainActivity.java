package com.example.fragmenttask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button currentButton, completeButton, repeatingButton;

    FragmentManager fm;
    FragmentTransaction ft;
    CurrentTaskFragment ctf;
    CompleteTaskFragment comtf;
    ArrayList<String> tasks = new ArrayList<>();
    RepeatingTaskFragment rtf;
    ArrayList<String> regularTasks = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        currentButton = findViewById(R.id.current_task_btn);
        completeButton = findViewById(R.id.complete_task_btn);
        repeatingButton = findViewById(R.id.repeating_task_btn);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ctf = new CurrentTaskFragment(tasks, regularTasks);
        comtf = new CompleteTaskFragment(tasks);
        rtf = new RepeatingTaskFragment(regularTasks);
        ft.add(R.id.container_task, ctf);
        ft.commit();

        currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                ft.replace(R.id.container_task, ctf);
                ft.commit();
            }
        });
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                ft.replace(R.id.container_task, comtf);
                ft.commit();
            }
        });
        repeatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = fm.beginTransaction();
                ft.replace(R.id.container_task, rtf);
                ft.commit();
            }
        });
    }
}