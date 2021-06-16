package spaceSurvival.game;

import javax.swing.SwingUtilities;

import spaceSurvival.controller.GUI.CtrlLoading;
import spaceSurvival.factories.factories.StaticFactoryEngineGUI;
import spaceSurvival.factories.factories.StaticFactoryGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.EngineMalaLoop;

public class LaunchMala {

    public static void main(final String[] args) {

        final CtrlLoading ctrlLoading = new CtrlLoading(StaticFactoryEngineGUI.createLoading(),
                StaticFactoryGUI.createLoading());
        ctrlLoading.start();

        final EngineMalaLoop engine = new EngineMalaLoop();
        while (!ctrlLoading.isLoad()) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        engine.initGame();
        ctrlLoading.turn(Visibility.HIDDEN);

//        engine.start();

        SwingUtilities.invokeLater(engine::start);
    }
}

