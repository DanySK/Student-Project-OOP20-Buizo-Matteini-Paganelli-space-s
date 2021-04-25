package model.GUI.help;

import model.image.EngineImage;
import utilities.IconPath;
import utilities.DesignImage;
import utilities.DesignJComponent;

import java.util.List;

public enum UnitsHelp {
    PANEL_MOVE(DesignJComponent.NAME_UNIT_HELP_MOVEMENT, List.of(
            new EngineImage(IconPath.ICON_WASD, DesignImage.RATE_ICON_PLURAL_HELP),
            new EngineImage(IconPath.ICON_ROW, DesignImage.RATE_ICON_PLURAL_HELP))),
    PANEL_SHOT(DesignJComponent.NAME_UNIT_HELP_SHOT, List.of(
            new EngineImage(IconPath.ICON_SPACEBAR,  DesignImage.RATE_ICON_PLURAL_HELP),
            new EngineImage(IconPath.ICON_KEY_K,  DesignImage.RATE_ICON_SINGULAR_HELP))),
    PANEL_PAUSE(DesignJComponent.NAME_UNIT_HELP_PAUSE, List.of(
            new EngineImage(IconPath.ICON_KEY_P, DesignImage.RATE_ICON_SINGULAR_HELP),
            new EngineImage(IconPath.ICON_PAUSE_GUI, DesignImage.RATE_ICON_SINGULAR_HELP)));

    private final String name;

    private final List<EngineImage> pathFiles;

    private UnitsHelp(final String name, final List<EngineImage> pathFiles){
        this.name = name;
        this.pathFiles = pathFiles;
    }

    public String getName(){
        return this.name;
    }

    public List<EngineImage> getPathFiles(){
        return this.pathFiles;
    }

    @Override
    public String toString() {
        return "HelpNamePanels{" +
                "name='" + name + '\'' +
                ", pathFiles=" + pathFiles +
                '}';
    }
}
