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
    int kSituation = 0;
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

        actionChooseBt.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (numberEdit.getText().toString().equals("1")) {
                    story.current_situation = story.start_story.direction[0];
                    manager.H+=story.current_situation.dH;
                    manager.K+=story.current_situation.dK;
                    manager.S+=story.current_situation.dS;
                    questText.setText("(1)Пойду в качалку что ли! Давно там не бывал");
                    kSituation += 1;
                } else if (numberEdit.getText().toString().equals("2")) {
                    story.current_situation = story.start_story.direction[1];
                    manager.H+=story.current_situation.dH;
                    manager.K+=story.current_situation.dK;
                    manager.S+=story.current_situation.dS;
                    questText.setText("(2)На пару схожу! А то от родителей получу за то, что прогуливаю");
                    kSituation += 1;
                } else if (numberEdit.getText().toString().equals("3")) {
                    story.current_situation = story.start_story.direction[2];
                    manager.H+=story.current_situation.dH;
                    manager.K+=story.current_situation.dK;
                    manager.S+=story.current_situation.dS;
                    questText.setText("(3)Пойду поплаваю! Получу удовольствие и прокачаюсь");
                    kSituation += 1;
                }
                if(kSituation == 1) {
                    name.setVisibility(View.VISIBLE);
                    characterHealth.setVisibility(View.VISIBLE);
                    characterKnowledge.setVisibility(View.VISIBLE);
                    characterStrength.setVisibility(View.VISIBLE);
                    numberEdit.setVisibility(View.INVISIBLE);
                    actionChooseBt.setVisibility(View.INVISIBLE);
                    action1Text.setVisibility(View.INVISIBLE);
                    action2Text.setVisibility(View.INVISIBLE);
                    action3Text.setVisibility(View.INVISIBLE);
                    characterHealth.setText("Здоровье: " + manager.H);
                    characterKnowledge.setText("Знания: " + manager.K);
                    characterStrength.setText("Сила: " + manager.S);
                } else {
                    double num = Double.parseDouble(actionChooseBt.getText().toString());
                    int num2 = (int) num;
                    story.go(num2);
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
                action1Text.setText("(1)Пойду в качалку что ли! Давно там не бывал");
                action2Text.setText("(2)На пару схожу! А то от родителей получу за то, что прогуливаю");
                action3Text.setText("(3)Пойду поплаваю! Получу удовольствие и прокачаюсь");
            }
        });
    }
}