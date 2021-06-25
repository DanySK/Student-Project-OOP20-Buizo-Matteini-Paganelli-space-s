package spacesurvival.controller.gui.command;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;

public class CmdOFF implements CmdEngine {

    /**
     * {@inheritDoc}
     */
    @Override
    public CmdGUI execute(final EngineGUI engine) {
        engine.setVisibility(Visibility.HIDDEN);
        return gui -> gui.setVisible(engine.getVisibility().isVisible());
    }
}
