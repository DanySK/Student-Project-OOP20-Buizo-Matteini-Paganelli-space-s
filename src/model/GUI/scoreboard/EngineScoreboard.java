package model.GUI.scoreboard;

import model.GUI.EngineGUI;
import utilities.IdGUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EngineScoreboard implements EngineGUI {
    private final String TITLE_SCOREBOARD = "SCOREBOARD";
    private final List<NameScoreboardGUI> nameButtons;

    private final IdGUI ID = IdGUI.ID_SCOREBOARD;
    private final IdGUI back = IdGUI.ID_BACK;

    private boolean state = false;

    public EngineScoreboard() {
        this.nameButtons = Arrays.asList(NameScoreboardGUI.values());
    }


    public String getTitleGUI(){
        return this.TITLE_SCOREBOARD;
    }
    @Override
    public boolean getState(){
        return this.state;
    }

    @Override
    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public IdGUI getId() {
        return ID;
    }
    @Override
    public IdGUI getLink() {
        return this.back;
    }
    @Override
    public List<IdGUI> getLinks() {
        return List.of(this.back);
    }

    public List<NameScoreboardGUI> getListName(){
        return this.nameButtons;
    }
}
