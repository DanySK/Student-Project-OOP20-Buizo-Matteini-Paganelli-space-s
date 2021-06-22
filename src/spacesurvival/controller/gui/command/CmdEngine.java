package spacesurvival.controller.gui.command;

import spacesurvival.model.gui.EngineGUI;

/**
 * Interface of command pattern for switch GUI 
 * 
 *
 */
public interface CmdEngine {
    CmdGUI execute(EngineGUI engineGUI);
}
