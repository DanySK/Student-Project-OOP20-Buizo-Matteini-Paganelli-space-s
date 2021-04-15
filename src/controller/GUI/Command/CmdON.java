package controller.GUI.Command;

import model.GUI.EngineGUI;
import model.GUI.Visibility;

public class CmdON implements CmdEngine {
    private EngineGUI engine;

    public CmdON(){ }

    @Override
    public CmdGUI execute(final EngineGUI engine) {
        this.engine = engine;
        this.engine.setVisibility(Visibility.VISIBLE);
        return gui -> gui.setVisible(CmdON.this.engine.getVisibility().isVisible());
    }
}
