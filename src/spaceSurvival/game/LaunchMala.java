package spaceSurvival.game;

import spaceSurvival.controller.GUI.CtrlLoading;
import spaceSurvival.factorys.StaticFactoryEngineGUI;
import spaceSurvival.factorys.StaticFactoryGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.game.EngineMalaLoop;

public class LaunchMala {

    public static void main(String[] args) {
        CtrlLoading ctrlLoading = new CtrlLoading(StaticFactoryEngineGUI.createLoading(),
                StaticFactoryGUI.createLoading());
        ctrlLoading.start();

        final EngineMalaLoop engine = new EngineMalaLoop();

        while(!ctrlLoading.isLoad()){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        engine.initGame();
        ctrlLoading.turn(Visibility.HIDDEN);
        engine.start();

    }
}

