package com.example.threadcalculate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText koef;
    TextView ans1, ans2;
    double [] coef = new double[4];
    double [] eqx1 = new double[2];
    double [] eqx2 = new double[2];

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        koef = (EditText) findViewById(R.id.koef);
        ans1 = (TextView) findViewById(R.id.ans1);
        ans2 = (TextView) findViewById(R.id.ans2);

    }

    public void Go(View view) {
        String [] koef_str = koef.getText().toString().split(" ");
        for (int i = 0; i < koef_str.length; i++) {
            coef[i] = Double.parseDouble(koef_str[i]);
        }
        eqx1 = solveEquation(coef[1], coef[2], coef[3]);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                eqx2 = solveEquation(coef[0], coef[1], coef[2]);
            }
        });
        t.start();
        String res ="UI Thread: \n" + eqx1[0] + "; \n" + eqx1[1];
        ans1.setText(res);
        while (t.getState() != Thread.State.TERMINATED) {

        }

        if (t.getState() == Thread.State.TERMINATED) {
            res = "Thread: \n" + eqx2[0] + "; \n" + eqx2[1];
            ans2.setText(res);
        }
    }

    public double [] solveEquation(double a, double b, double c) {
        double [] roots = new double[2];
        double d = b * b - 4 * a * c;
        if (d >= 0) {
            roots[0] = (-b + Math.sqrt(d)) / (2 * a);
            roots[1] = (-b - Math.sqrt(d)) / (2 * a);
        } else {
            roots[0] = Double.NEGATIVE_INFINITY;
            roots[1] = Double.NEGATIVE_INFINITY;
        } return roots;
    }
}