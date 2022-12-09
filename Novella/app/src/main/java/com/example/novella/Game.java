package com.example.novella;

public class Game extends MainActivity{
    public static Character manager;
    public static Story story;
    public static void main() {
        story = new Story();
        while (true){
            manager.H+=story.current_situation.dH;
            manager.K+=story.current_situation.dK;
            manager.S+=story.current_situation.dS;
            if(story.isEnd()){
                return;
            }
        }
    }
}
