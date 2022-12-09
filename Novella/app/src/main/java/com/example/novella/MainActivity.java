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

        Character character = new Character(name.getText().toString());
        Game game = new Game();
        Story story = new Story();
        game.main();

        actionChooseBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(story.isEnd()) {

                }
                double num = Double.parseDouble(actionChooseBt.getText().toString());
                story.go((int)num);
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
            }
        });
    }
}