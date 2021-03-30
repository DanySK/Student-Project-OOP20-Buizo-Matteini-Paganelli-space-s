package controller.GUI.Command;

import model.GUI.EngineGUI;

public class CmdOFFGUI implements CmdEngine {
    private EngineGUI engine;

    public CmdOFFGUI(){
    }

    @Override
    public CmdGUI execute(final EngineGUI engine) {
        this.engine = engine;
        this.engine.setState(false);
        return gui -> gui.setVisible(CmdOFFGUI.this.engine.getState());
    }
}
