package spaceSurvival.controller.GUI.command;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;

public class CmdOFF implements CmdEngine {
    private EngineGUI engine;

    public CmdOFF(){ }

    @Override
    public CmdGUI execute(final EngineGUI engine) {
        this.engine = engine;
        this.engine.setVisibility(Visibility.HIDDEN);
        return gui -> gui.setVisible(CmdOFF.this.engine.getVisibility().isVisible());
    }
}
