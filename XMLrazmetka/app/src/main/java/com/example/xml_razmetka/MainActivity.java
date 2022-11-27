package com.example.xml_razmetka;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.content.res.Resources;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView numQuest, textQuest, progressText;
    RadioGroup varAnswers;
    Button sendAnswer;
    int countQuest = 1;
    Resources resources;
    String [] test;
    int countRightQuest = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numQuest = findViewById(R.id.num_quest);
        textQuest = findViewById(R.id.text_quest);
        progressText = findViewById(R.id.progress_text);
        varAnswers = findViewById(R.id.var_answer);
        sendAnswer = findViewById(R.id.send_answer);

        resources = getResources();
        test = resources.getStringArray(R.array.test);

        String tmp = "Вопрос № " + countQuest;
        numQuest.setText(tmp);

        textQuest.setText(test[0]);

        tmp = countQuest + "/" + test.length / 5;
        progressText.setText(tmp);

        for (int i = 0; i < varAnswers.getChildCount(); i++) {
            if(!test[i + 1].endsWith("+")) {
                ((RadioButton)varAnswers.getChildAt(i)).setText(test[i + 1]);
            } else {
                tmp = test[i + 1].substring(0, test[i + 1].length() - 1);
                ((RadioButton)varAnswers.getChildAt(i)).setText(tmp);
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public void sendAnswer(View view) {
        RadioButton radioButton;
        for (int i = 0; i < varAnswers.getChildCount(); i++) {
            radioButton = (RadioButton)varAnswers.getChildAt(i);
            int numAnswer = (countQuest - 1) * 5;
            if (radioButton.isChecked()) {
                for (int j = 0; j < varAnswers.getChildCount(); j++) {
                    String rightAnswer = test[numAnswer + j + 1];
                    String nowAnswer = radioButton.getText() + "+";
                    if (nowAnswer.equals(rightAnswer)) {
                        countRightQuest += 1;
                        break;
                    }
                }
            }
        }
        countQuest++;
        if (countQuest <= test.length / 5) {
            String tmp = "Вопрос № " + countQuest;
            numQuest.setText(tmp);
            textQuest.setText(test[(countQuest - 1) * 5]);
            tmp = countQuest + "/" + test.length / 5;
            progressText.setText(tmp);
            for (int i = 0; i < varAnswers.getChildCount(); i++) {
                int numAnswer = (countQuest - 1) * 5;
                if (!test[numAnswer + i + 1].endsWith("+")) {
                    ((RadioButton) varAnswers.getChildAt(i)).setText(test[numAnswer + i + 1]);
                } else {
                    tmp = test[numAnswer + i + 1].substring(0, test[numAnswer + i + 1].length() - 1);
                    ((RadioButton) varAnswers.getChildAt(i)).setText(tmp);
                }
            }
        } else {
            numQuest.setText("Результат:");
            textQuest.setText(countRightQuest + " из " + (countQuest-1));
            varAnswers.setVisibility(View.INVISIBLE);
            progressText.setVisibility(View.INVISIBLE);
            sendAnswer.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.exit:
                this.finishAffinity();
        }
        return true;
    }
}