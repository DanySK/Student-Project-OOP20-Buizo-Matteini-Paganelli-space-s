package spacesurvival.view.pause.utilities;

import spacesurvival.utilities.pathImage.Icon;

public enum IconsButton {
    ICON_RESUME(Icon.RESUME),
    ICON_SOUND(Icon.SOUND),
    ICON_HELP(Icon.HELP),
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
