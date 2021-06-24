package spacesurvival.launchgame;

import spacesurvival.controller.gui.CtrlLoading;
import spacesurvival.view.StaticFactoryGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.Delay;
import spacesurvival.utilities.ThreadUtils;
import spacesurvival.model.EngineLoop;
import spacesurvival.model.gui.StaticFactoryEngineGui;

public final class LaunchSpace {

    private LaunchSpace() {
    }

    public static void main(final String[] args) {

        final CtrlLoading ctrlLoading = new CtrlLoading(StaticFactoryEngineGui.createLoading(),
                StaticFactoryGUI.createLoading());
        ctrlLoading.initLoading();
        ctrlLoading.start();


        final EngineLoop engineLoop = new EngineLoop();
        while (!ctrlLoading.isLoad()) {
            ThreadUtils.sleep(Delay.LOADING_UPDATE);
        }

        engineLoop.initGame();
        ctrlLoading.turn(Visibility.HIDDEN);

        engineLoop.start();
//        SwingUtilities.invokeLater(engineLoop::start);
    }
}

