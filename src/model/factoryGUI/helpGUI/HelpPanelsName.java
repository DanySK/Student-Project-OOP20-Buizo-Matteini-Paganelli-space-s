package model.factoryGUI.helpGUI;

import model.MyJImage.MyJImageEngine;
import utilities.DesignSpace;

import java.util.ArrayList;
import java.util.List;

public enum HelpPanelsName {
    PANEL_MOVE("Movement", List.of(new MyJImageEngine(DesignSpace.SIZE_IMAGE_MEDIUM * 3,
                    DesignSpace.SIZE_IMAGE_MEDIUM * 2,
                    "iconCommand/wasd.png"),
            new MyJImageEngine(DesignSpace.SIZE_IMAGE_MEDIUM * 3,
                    DesignSpace.SIZE_IMAGE_MEDIUM * 2,
                    "iconCommand/row.png"))),
    PANEL_SHOT("Shot", List.of(new MyJImageEngine(DesignSpace.SIZE_IMAGE_MEDIUM * 2,
                    DesignSpace.SIZE_IMAGE_MEDIUM, "iconCommand/spacebar.png"),
            DesignSpace.modificationSizeMediumImage(new MyJImageEngine("iconCommand/keyK.png")))),
    PANEL_PAUSE("Pause", List.of(DesignSpace
            .modificationSizeMediumImage(new MyJImageEngine("iconCommand/keyP.png")),
            DesignSpace.modificationSizeMediumImage(new MyJImageEngine("iconCommand/pause.png"))));

    private String name;

    private List<MyJImageEngine> pathFiles = new ArrayList<>();

    private HelpPanelsName(final String name, final List<MyJImageEngine> pathFiles){
        this.name = name;
        this.pathFiles.addAll(pathFiles);
    }

    public String getName(){
        return this.name;
    }

    public List<MyJImageEngine> getPathFiles(){
        return this.pathFiles;
    }
}
