package spacesurvival.controller.gui.command;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;

public class CmdOFF implements CmdEngine {
    private EngineGUI engine;

    @Override
    public CmdGUI execute(final EngineGUI engine) {
        this.engine = engine;
        this.engine.setVisibility(Visibility.HIDDEN);
        return gui -> gui.setVisible(CmdOFF.this.engine.getVisibility().isVisible());
    }
}
