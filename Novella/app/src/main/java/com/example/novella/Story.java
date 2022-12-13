package com.example.novella;

public class Story {
    Situation start_story;
    public Situation current_situation;
    Story() {
        start_story = new Situation("первая день","Первый день будет очень насыщенный! Чем же мне заняться?",3, 0, 0, 0);
        start_story.direction[0]=new Situation("качалка", "Пойду в качалку что ли! Давно там не бывал", 0, 0, -10, -10);
        start_story.direction[1]=new Situation("универ", "На пару схожу! А то от родителей получу за то, что прогуливаю", 0, 1, 100, 0);
        start_story.direction[2]=new Situation("плавание", "Пойду поплаваю! Получу удовольствие и прокачаюсь", 0, 0, 50, 1);

        current_situation=start_story;
    }
    public void go(int num) {
        if(num<=current_situation.direction.length)
            current_situation=current_situation.direction[num-1];
    }
    public boolean isEnd(){
        return current_situation.direction.length==0;
    }
}