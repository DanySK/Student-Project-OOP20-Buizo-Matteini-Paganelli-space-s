package controller.GUI.Command;

import model.factoryGUI.GUIEngine;

public interface CommandEngine {
    public CommandGUI execute(final GUIEngine engineGUI);
}
