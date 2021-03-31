package controller.GUI.Command;

import model.GUI.EngineGUI;

public class CmdON implements CmdEngine {
    private EngineGUI engine;

    public CmdON(){
    }

    @Override
    public CmdGUI execute(final EngineGUI engine) {
        this.engine = engine;
        this.engine.setState(true);
        return gui -> gui.setVisible(CmdON.this.engine.getState());
    }
}
