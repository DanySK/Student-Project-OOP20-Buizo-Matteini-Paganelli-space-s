package spacesurvival.model.gui.pause;

import spacesurvival.utilities.ActionGUI;

public enum LinksPause {
    RESUME_BUTTON("Resume", ActionGUI.ID_BACK),
    SOUND_BUTTON("Sound", ActionGUI.ID_SOUND),
    HELP_BUTTON("Help", ActionGUI.ID_HELP),
    QUIT_BUTTON("Quit", ActionGUI.ID_QUIT);

    private final String name;
    private final ActionGUI actionGUI;

    private LinksPause(final String name, final ActionGUI actionGUI){
        this.name = name;
        this.actionGUI = actionGUI;
    }

    public String getName(){
        return this.name;
    }

    public ActionGUI getIdGUI(){
        return this.actionGUI;
    }
}
