package controller.GUI.Command;

import model.GUI.EngineGUI;

public class CmdONGUI implements CmdEngine {
    private EngineGUI engine;

    public CmdONGUI(){
    }

    @Override
    public CmdGUI execute(final EngineGUI engine) {
        this.engine = engine;
        this.engine.setState(true);
        return gui -> gui.setVisible(CmdONGUI.this.engine.getState());
    }
}
