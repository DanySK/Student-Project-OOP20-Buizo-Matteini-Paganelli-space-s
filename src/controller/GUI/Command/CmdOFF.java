package controller.GUI.Command;

import model.GUI.EngineGUI;

public class CmdOFF implements CmdEngine {
    private EngineGUI engine;

    public CmdOFF(){
    }

    @Override
    public CmdGUI execute(final EngineGUI engine) {
        this.engine = engine;
        this.engine.setState(false);
        return gui -> gui.setVisible(CmdOFF.this.engine.getState());
    }
}
