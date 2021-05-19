package spaceSurvival.model.GUI.menu;

import spaceSurvival.utilities.IdGUI;

public enum LinksMenu {
    START_BUTTON("Start", IdGUI.ID_GAME),
    SETTINGS_BUTTON("Settings", IdGUI.ID_SETTING),
    SCOREBOARD_BUTTON("Scoreboard", IdGUI.ID_SCOREBOARD),
    SOUND_BUTTON("Sound", IdGUI.ID_SOUND),
    HELP_BUTTON("Help", IdGUI.ID_HELP),
    QUIT_BUTTON("Quit", IdGUI.ID_QUIT);

    private final String name;
    private final IdGUI idGUI;

    private LinksMenu(final String name, final IdGUI idGUI){
        this.name = name;
        this.idGUI = idGUI;
    }

    public String getName(){
        return this.name;
    }

    public IdGUI getIdGUI() {
        return this.idGUI;
    }

    @Override
    public String toString() {
        return "LinksMenuGUI{" +
                "name='" + name + '\'' +
                ", idGUI=" + idGUI +
                '}';
    }
}