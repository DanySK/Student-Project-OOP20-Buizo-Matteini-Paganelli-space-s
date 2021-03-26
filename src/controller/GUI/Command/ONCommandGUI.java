package controller.GUI.Command;

import model.factoryGUI.GUIEngine;

public class ONCommandGUI implements CommandEngine {
    private GUIEngine engine;

    public ONCommandGUI(){
    }

    @Override
    public CommandGUI execute(final GUIEngine engine) {
        this.engine = engine;
        this.engine.setState(true);
        return gui -> gui.setVisible(ONCommandGUI.this.engine.getState());
    }
}
