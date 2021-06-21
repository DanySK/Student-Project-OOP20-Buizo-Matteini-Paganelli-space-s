package spacesurvival.model.gui.pause;

import spacesurvival.utilities.LinkActionGUI;

public enum LinksPause {
    RESUME_BUTTON("Resume", LinkActionGUI.ID_BACK),
    SOUND_BUTTON("Sound", LinkActionGUI.ID_SOUND),
    HELP_BUTTON("Help", LinkActionGUI.ID_HELP),
    QUIT_BUTTON("Quit", LinkActionGUI.ID_QUIT);

    private final String name;
    private final LinkActionGUI linkActionGUI;

    private LinksPause(final String name, final LinkActionGUI linkActionGUI){
        this.name = name;
        this.linkActionGUI = linkActionGUI;
    }

    public String getName(){
        return this.name;
    }

    public LinkActionGUI getIdGUI(){
        return this.linkActionGUI;
    }
}
