package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name, numberEdit;
    Button actionChooseBt, nameChooseBt;
    TextView action1Text, action2Text, action3Text, characterHealth, characterKnowledge, characterStrength, questText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        numberEdit = (EditText) findViewById(R.id.numberEdit);
        actionChooseBt = (Button) findViewById(R.id.actionChooseButton);
        nameChooseBt = (Button) findViewById(R.id.nameChoose);
        questText = (TextView) findViewById(R.id.questionText);
        action1Text = (TextView) findViewById(R.id.action1Text);
        action2Text = (TextView) findViewById(R.id.action2Text);
        action3Text = (TextView)findViewById(R.id.action3Text);
        characterHealth = (TextView)findViewById(R.id.healthText);
        characterKnowledge = (TextView)findViewById(R.id.knowledgeText);
        characterStrength = (TextView)findViewById(R.id.strengthText);

        Character manager = new Character(name.getText().toString());
        Story story = new Story();
        if(!("".equals(name.getText().toString()))){
            Game game = new Game(manager);
        }

        actionChooseBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(story.isEnd()) {

                } else {
                    double num = Double.parseDouble(actionChooseBt.getText().toString());
                    story.go((int) num);
                }
            }
        });
        nameChooseBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setVisibility(View.INVISIBLE);
                nameChooseBt.setVisibility(View.INVISIBLE);
                characterHealth.setVisibility(View.INVISIBLE);
                characterKnowledge.setVisibility(View.INVISIBLE);
                characterStrength.setVisibility(View.INVISIBLE);
                numberEdit.setVisibility(View.VISIBLE);
                actionChooseBt.setVisibility(View.VISIBLE);
                questText.setVisibility(View.VISIBLE);
                action1Text.setVisibility(View.VISIBLE);
                action2Text.setVisibility(View.VISIBLE);
                action3Text.setVisibility(View.VISIBLE);
                questText.setText("Первый день будет очень насыщенный! Чем же мне заняться?");
                action1Text.setText("Пойду в качалку что ли! Давно там не бывал");
                action2Text.setText("На пару схожу! А то от родителей получу за то, что прогуливаю");
                action3Text.setText("Пойду поплаваю! Получу удовольствие и прокачаюсь");
            }
        });
    }
}