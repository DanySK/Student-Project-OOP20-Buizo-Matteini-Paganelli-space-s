package model.GUI.scoreboard;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.IdGUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EngineScoreboard implements EngineGUI {
    private final String TITLE_SCOREBOARD = "SCOREBOARD";
    private final List<NameScoreboardGUI> nameButtons;

    private final IdGUI ID = IdGUI.ID_SCOREBOARD;
    private final IdGUI linBack = IdGUI.ID_BACK;

    private Visibility visibility = Visibility.HIDDEN;

    public EngineScoreboard() {
        this.nameButtons = Arrays.asList(NameScoreboardGUI.values());
    }


    public String getTitleGUI(){
        return this.TITLE_SCOREBOARD;
    }

    @Override
    public Visibility getVisibility(){
        return this.visibility;
    }

    @Override
    public void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public IdGUI getId() {
        return ID;
    }

    @Override
    public List<IdGUI> getLinks() {
        return List.of(this.linBack);
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    public IdGUI getBackLink(){
        return this.linBack;
    }

    public List<NameScoreboardGUI> getListName(){
        return this.nameButtons;
    }
}
