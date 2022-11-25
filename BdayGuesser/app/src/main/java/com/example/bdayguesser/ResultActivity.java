package com.example.bdayguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class ResultActivity extends AppCompatActivity {
    TextView textView;
    String firstPart;
    String secondPart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String name = getIntent().getStringExtra("name");
        int day = getIntent().getIntExtra("day", 0);
        String[] days = getResources().getStringArray(R.array.days);
        String[] names = getResources().getStringArray(R.array.names);
        textView = findViewById(R.id.textView);
        firstPart = "";
        secondPart = days[day - 1];
        for (String text : names){
            if (text.toLowerCase(Locale.ROOT).charAt(0) == name.toLowerCase(Locale.ROOT).charAt(0)){
                firstPart = text.substring(1);
                break;
            }
        }
        textView.setText(firstPart + " " + secondPart.toLowerCase(Locale.ROOT));
    }

    public void onClick2(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Я скачал(а) приложения от " +
                "Никиты Долбак и узнал, что ес илбы меня продавали на Aliexpress, " +
                "то я бы был(а) " + firstPart + " " + secondPart.toLowerCase(Locale.ROOT));
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}
