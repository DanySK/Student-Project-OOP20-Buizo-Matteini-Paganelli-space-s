package view.GUI.menu.utilities;

public enum IconsButton {
    ICON_START("iconButton/start.png"),
    ICON_SETTINGS("iconButton/settings.png"),
    ICON_SCOREBOARD("iconButton/scoreboard.png"),
    ICON_SOUND("iconButton/sound.png"),
    ICON_HELP("iconButton/help.png"),
    ICON_QUIT("iconButton/quit.png");

    private String path;

    private IconsButton(final String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
