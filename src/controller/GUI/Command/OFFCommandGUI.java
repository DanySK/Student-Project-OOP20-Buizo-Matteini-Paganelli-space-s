package controller.GUI.Command;

import model.factoryGUI.GUIEngine;

public class OFFCommandGUI implements CommandEngine {
    private GUIEngine engine;

    public OFFCommandGUI(){
    }

    @Override
    public CommandGUI execute(final GUIEngine engine) {
        this.engine = engine;
        this.engine.setState(false);
        return gui -> gui.setVisible(OFFCommandGUI.this.engine.getState());
    }
}
