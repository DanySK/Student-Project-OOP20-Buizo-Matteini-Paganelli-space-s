package game;

import factorys.StaticFactoryGUI;
import model.game.GameMalaLoop;
import view.GUI.Loading.GUILoading;
import view.GUI.Loading.concrete.GUILoadingConcrete;

public class LaunchMala {

    public static void main(String[] args){
        GUILoading loading = StaticFactoryGUI.createLoading();
        loading.setVisible(true);


        final GameMalaLoop engine = new GameMalaLoop();
        engine.initGame();
        engine.mainLoop();
    }
}

