package spacesurvival.game;


import spacesurvival.controller.gui.CtrlLoading;
import spacesurvival.factories.StaticFactoryGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.EngineMalaLoop;

import javax.swing.SwingUtilities;

import spacesurvival.factories.StaticFactoryEngineGUI;

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

