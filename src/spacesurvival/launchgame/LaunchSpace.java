package spacesurvival.launchgame;

import spacesurvival.controller.gui.CtrlLoading;
import spacesurvival.factories.StaticFactoryGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.ThreadUtils;
import spacesurvival.model.EngineLoop;
import spacesurvival.factories.StaticFactoryEngineGUI;

public final class LaunchSpace {

    private LaunchSpace() {
    }

    public static void main(final String[] args) {

        final CtrlLoading ctrlLoading = new CtrlLoading(StaticFactoryEngineGUI.createLoading(),
                StaticFactoryGUI.createLoading());
        ctrlLoading.start();

        final EngineLoop engineLoop = new EngineLoop();
        while (!ctrlLoading.isLoad()) {
            ThreadUtils.sleep(5);
        }

        engineLoop.initGame();
        ctrlLoading.turn(Visibility.HIDDEN);

        engineLoop.start();
//        SwingUtilities.invokeLater(engine::start);
    }
}

