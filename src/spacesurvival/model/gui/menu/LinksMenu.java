package spacesurvival.model.gui.menu;

import spacesurvival.utilities.LinkActionGUI;

public enum LinksMenu {
    START_BUTTON("Start", LinkActionGUI.ID_GAME),
    SETTINGS_BUTTON("Settings", LinkActionGUI.ID_SETTING),
    SOUND_BUTTON("Sound", LinkActionGUI.ID_SOUND),
    HELP_BUTTON("Help", LinkActionGUI.ID_HELP),
    QUIT_BUTTON("Quit", LinkActionGUI.ID_QUIT);

    private final String name;
    private final LinkActionGUI linkActionGUI;

    private LinksMenu(final String name, final LinkActionGUI linkActionGUI){
        this.name = name;
        this.linkActionGUI = linkActionGUI;
    }

    public String getName(){
        return this.name;
    }

    public LinkActionGUI getAction() {
        return this.linkActionGUI;
    }

    @Override
    public String toString() {
        return "LinksMenu{" +
                "name='" + name + '\'' +
                ", actionGUI=" + linkActionGUI + '}';
    }
}