package view.GUI.pause.utilities;

import utilities.pathImage.Icon;

public enum IconsButton {
    ICON_RESUME(Icon.START),
    ICON_HELP(Icon.SETTINGS),
    ICON_SOUND(Icon.SOUND),
    ICON_QUI(Icon.QUIT);

    private String path;

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
