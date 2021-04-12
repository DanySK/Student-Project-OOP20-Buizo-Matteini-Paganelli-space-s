package model.GUI.help;

import model.MyJImage.JImageRateEngine;

import java.util.ArrayList;
import java.util.List;

public enum HelpNamePanels {
    PANEL_MOVE("Movement", List.of(new JImageRateEngine("imgHelp/wasd.png", 15),
            new JImageRateEngine("imgHelp/row.png", 15))),
    PANEL_SHOT("Shot", List.of(new JImageRateEngine("imgHelp/space.png", 15),
            new JImageRateEngine("imgHelp/key_K.png", 5))),
    PANEL_PAUSE("Pause", List.of(new JImageRateEngine("imgHelp/key_P.png", 5),
            new JImageRateEngine("imgHelp/pause.png", 5)));

    private String name;

    private List<JImageRateEngine> pathFiles = new ArrayList<>();

    private HelpNamePanels(final String name, final List<JImageRateEngine> pathFiles){
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
