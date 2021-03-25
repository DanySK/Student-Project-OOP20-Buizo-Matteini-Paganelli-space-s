package model.factoryGUI.helpGUI;

import model.MyJImage.JImageRateEngine;
import view.utilities.JImageRate;

import java.util.ArrayList;
import java.util.List;

public enum HelpPanelsName {
    PANEL_MOVE("Movement", List.of(new JImageRateEngine("iconCommand/wasd.png", 20),
            new JImageRateEngine( "iconCommand/row.png", 20))),
    PANEL_SHOT("Shot", List.of(new JImageRateEngine("iconCommand/spacebar.png", 20),
            new JImageRateEngine("iconCommand/keyK.png", 10))),
    PANEL_PAUSE("Pause", List.of(new JImageRateEngine("iconCommand/keyP.png", 10),
            new JImageRateEngine("iconCommand/pause.png", 10)));

    private String name;

    private List<JImageRateEngine> pathFiles = new ArrayList<>();

    private HelpPanelsName(final String name, final List<JImageRateEngine> pathFiles){
        this.name = name;
        this.pathFiles.addAll(pathFiles);
    }

    public String getName(){
        return this.name;
    }

    public List<JImageRateEngine> getPathFiles(){
        return this.pathFiles;
    }
}
