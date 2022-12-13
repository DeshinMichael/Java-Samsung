package com.example.novella;

public class Game {
    public static Character manager;
    public static Story story;

    public Game(Character manager2) {
        manager.name = manager2.name;
        Game.main();
    }

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
