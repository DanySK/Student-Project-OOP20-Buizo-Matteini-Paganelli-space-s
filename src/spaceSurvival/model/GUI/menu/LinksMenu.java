package spaceSurvival.model.GUI.menu;

import spaceSurvival.utilities.ActionGUI;

public enum LinksMenu {
    START_BUTTON("Start", ActionGUI.ID_GAME),
    SETTINGS_BUTTON("Settings", ActionGUI.ID_SETTING),
    SCOREBOARD_BUTTON("Scoreboard", ActionGUI.ID_SCOREBOARD),
    SOUND_BUTTON("Sound", ActionGUI.ID_SOUND),
    HELP_BUTTON("Help", ActionGUI.ID_HELP),
    QUIT_BUTTON("Quit", ActionGUI.ID_QUIT);

    private final String name;
    private final ActionGUI actionGUI;

    private LinksMenu(final String name, final ActionGUI actionGUI){
        this.name = name;
        this.actionGUI = actionGUI;
    }

    public String getName(){
        return this.name;
    }

    public ActionGUI getActionGUI() {
        return this.actionGUI;
    }

    @Override
    public String toString() {
        return "LinksMenu{" +
                "name='" + name + '\'' +
                ", actionGUI=" + actionGUI + '}';
    }
}