package view.GUI.menu.utilities;

public enum IconsButton {
    ICON_START("icon/start.png"),
    ICON_SETTINGS("icon/settings.png"),
    ICON_SCOREBOARD("icon/scoreboard.png"),
    ICON_SOUND("icon/sound.png"),
    ICON_HELP("icon/help.png"),
    ICON_QUIT("icon/quit.png");

    private String path;

    private IconsButton(final String path){
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
