package spacesurvival.controller.gui.command;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;

public class CmdON implements CmdEngine {
    private EngineGUI engine;

    @Override
    public CmdGUI execute(final EngineGUI engine) {
        this.engine = engine;
        this.engine.setVisibility(Visibility.VISIBLE);
        return gui -> gui.setVisible(this.engine.getVisibility().isVisible());
    }
}
