package spaceSurvival.game;

import spaceSurvival.factorys.StaticFactoryGUI;
import spaceSurvival.model.game.GameMalaLoop;
import spaceSurvival.view.GUI.Loading.GUILoading;

public class LaunchMala {

    public static void main(String[] args){
        GUILoading loading = StaticFactoryGUI.createLoading();
        loading.setVisible(true);


        final GameMalaLoop engine = new GameMalaLoop();
        engine.initGame();
        engine.mainLoop();
    }
}

