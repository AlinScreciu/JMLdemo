package com.company;

public class StartGame {
    public static void main(String[] args) {

        int i = 30;
        while (i-- >= 0){
            Match game = new Match("Team1", "Team2");
            game.play();
            System.out.println(game);
        }
    }
}
