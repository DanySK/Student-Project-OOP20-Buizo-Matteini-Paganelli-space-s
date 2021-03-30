package model.GUI.menu;

public enum NameMenuGUI {
    START_BUTTON("Start"),
    SETTINGS_BUTTON("Settings"),
    SCOREBOARD_BUTTON("Scoreboard"),
    HELP_BUTTON("Help"),
    QUIT_BUTTON("Quit");

    private final String name;


    private NameMenuGUI(final String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}