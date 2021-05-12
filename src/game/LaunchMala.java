package game;

import model.game.GameMalaLoop;

public class LaunchMala {

    public static void main(String[] args){
        final GameMalaLoop gameMala = new GameMalaLoop();
        gameMala.initGame();
        gameMala.mainLoop();
    }
}

