package spacesurvival.game;

import javax.swing.SwingUtilities;

import spacesurvival.controller.GUI.CtrlLoading;
import spacesurvival.factories.factories.StaticFactoryEngineGUI;
import spacesurvival.factories.factories.StaticFactoryGUI;
import spacesurvival.model.GUI.Visibility;
import spacesurvival.model.EngineMalaLoop;

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

