package spacesurvival.controller.gui.command;

import spacesurvival.model.gui.EngineGUI;

public interface CmdEngine {
    CmdGUI execute(EngineGUI engineGUI);
}
