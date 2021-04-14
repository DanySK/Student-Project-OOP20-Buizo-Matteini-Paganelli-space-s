package model.GUI.help;

import model.MyJImage.JImageRateEngine;
import utilities.DesignImage;

import java.util.ArrayList;
import java.util.List;

public enum UnitsHelp {
    PANEL_MOVE("Movement", List.of(
            new JImageRateEngine("imgHelp/wasd.png", DesignImage.RATE_ICON_PLURAL_HELP),
            new JImageRateEngine("imgHelp/row.png", DesignImage.RATE_ICON_PLURAL_HELP))),
    PANEL_SHOT("Shot", List.of(
            new JImageRateEngine("imgHelp/space.png",  DesignImage.RATE_ICON_PLURAL_HELP),
            new JImageRateEngine("imgHelp/key_K.png",  DesignImage.RATE_ICON_SINGULAR_HELP))),
    PANEL_PAUSE("Pause", List.of(
            new JImageRateEngine("imgHelp/key_P.png", DesignImage.RATE_ICON_SINGULAR_HELP),
            new JImageRateEngine("imgHelp/pause.png", DesignImage.RATE_ICON_SINGULAR_HELP)));

    private final String name;

    private final List<JImageRateEngine> pathFiles = new ArrayList<>();

    private UnitsHelp(final String name, final List<JImageRateEngine> pathFiles){
        this.name = name;
        this.pathFiles.addAll(pathFiles);
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
