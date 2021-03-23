package controller.CommandGUI;

import model.factoryGUI.GUIEngine;

public class ONCommandEngine implements CommandEngine {
    private GUIEngine engine;

    public ONCommandEngine(){
    }

    @Override
    public CommandGUI execute(final GUIEngine engine) {
        this.engine = engine;
        this.engine.setState(true);
        return gui -> gui.setVisible(ONCommandEngine.this.engine.getState());
    }
}
