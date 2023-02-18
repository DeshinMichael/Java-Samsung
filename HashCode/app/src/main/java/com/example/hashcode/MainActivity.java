package com.example.hashcode;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvHs, tvTs;
    Button btnPut, btnWr;
    EditText edText;
    HashSet<String> myHashSet = new HashSet<String>();
    TreeSet<String> myTreeSet = new TreeSet<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHs = findViewById(R.id.tvHashset);
        tvTs = findViewById(R.id.tvTreeset);
        btnPut = findViewById(R.id.btAdd);
        btnWr = findViewById(R.id.btWrite);
        edText = findViewById(R.id.etElements);

        btnPut.setOnClickListener(this);
        btnWr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btAdd:
                myHashSet.add(edText.getText().toString());
                myTreeSet.add(edText.getText().toString());
                edText.setText("");
                break;
            case R.id.btWrite:
                btnPut.setVisibility(View.INVISIBLE);
                tvHs.setText("");
                tvTs.setText("");
                for (String bfr : myHashSet) {
                    tvHs.append(bfr+"\n");
                }
                for (String bfr : myTreeSet) {
                    tvTs.append(bfr+"\n");
                }
                break;
        }
    }
}