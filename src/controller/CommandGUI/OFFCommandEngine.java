package controller.CommandGUI;

import model.factoryGUI.GUIEngine;

public class OFFCommandEngine implements CommandEngine {
    private GUIEngine engine;

    public OFFCommandEngine(){
    }

    @Override
    public CommandGUI execute(final GUIEngine engine) {
        this.engine = engine;
        this.engine.setState(false);
        return gui -> gui.setVisible(OFFCommandEngine.this.engine.getState());
    }
}
