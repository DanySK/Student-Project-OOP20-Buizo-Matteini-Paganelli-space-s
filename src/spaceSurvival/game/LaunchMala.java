package spaceSurvival.game;

import spaceSurvival.controller.GUI.CtrlLoading;
import spaceSurvival.factorys.StaticFactoryEngineGUI;
import spaceSurvival.factorys.StaticFactoryGUI;
import spaceSurvival.model.game.GameMalaLoop;
import spaceSurvival.view.GUI.Loading.GUILoading;

public class LaunchMala {

    public static void main(String[] args) {
        CtrlLoading ctrlLoading = new CtrlLoading(StaticFactoryEngineGUI.createLoading(),
                StaticFactoryGUI.createLoading());
        ctrlLoading.start();


        final GameMalaLoop engine = new GameMalaLoop();

        while(!ctrlLoading.isLoad()){
            if(!ctrlLoading.isVisibility()){
                engine.initGame();
                engine.start();
            }

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }




    }
}

