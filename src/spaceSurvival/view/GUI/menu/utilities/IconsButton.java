package spaceSurvival.view.GUI.menu.utilities;

import spaceSurvival.utilities.pathImage.Icon;

public enum IconsButton {
    ICON_START(Icon.START),
    ICON_SETTINGS(Icon.SETTINGS),
    ICON_SCOREBOARD(Icon.SCOREBOARD),
    ICON_SOUND(Icon.SOUND),
    ICON_HELP(Icon.HELP),
    ICON_QUIT(Icon.QUIT);

    private final String path;

    private IconsButton(final String path){
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    @Override
    public String toString() {
        return "IconsButton{" +
                "path='" + path + '\'' +
                '}';
    }
}
