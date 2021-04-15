package model.GUI.help;

import model.MyJImage.JImageRateEngine;
import utilities.DefaultPathIcon;
import utilities.DesignImage;
import utilities.DesignJComponent;

import java.util.ArrayList;
import java.util.List;

public enum UnitsHelp {
    PANEL_MOVE(DesignJComponent.NAME_UNIT_HELP_MOVEMENT, List.of(
            new JImageRateEngine(DefaultPathIcon.ICON_WASD, DesignImage.RATE_ICON_PLURAL_HELP),
            new JImageRateEngine(DefaultPathIcon.ICON_ROW, DesignImage.RATE_ICON_PLURAL_HELP))),
    PANEL_SHOT(DesignJComponent.NAME_UNIT_HELP_SHOT, List.of(
            new JImageRateEngine(DefaultPathIcon.ICON_SPACEBAR,  DesignImage.RATE_ICON_PLURAL_HELP),
            new JImageRateEngine(DefaultPathIcon.ICON_KEY_K,  DesignImage.RATE_ICON_SINGULAR_HELP))),
    PANEL_PAUSE(DesignJComponent.NAME_UNIT_HELP_PAUSE, List.of(
            new JImageRateEngine(DefaultPathIcon.ICON_KEY_P, DesignImage.RATE_ICON_SINGULAR_HELP),
            new JImageRateEngine(DefaultPathIcon.ICON_PAUSE, DesignImage.RATE_ICON_SINGULAR_HELP)));

    private final String name;

    private final List<JImageRateEngine> pathFiles;

    private UnitsHelp(final String name, final List<JImageRateEngine> pathFiles){
        this.name = name;
        this.pathFiles = pathFiles;
    }

    public String getName(){
        return this.name;
    }

    public List<JImageRateEngine> getPathFiles(){
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
