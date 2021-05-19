package spaceSurvival.model.GUI.scoreboard;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.DesignTitleGUI;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineScoreboard implements EngineGUI {
    public static final Rectangle DIMENSION = Screen.RECTANGLE_MEDIUM;

    private final IdGUI id;
    private final IdGUI linkBack;

    private final List<NameScoreboardGUI> nameButtons;

    private Visibility visibility;

    public EngineScoreboard() {
        this.id = IdGUI.ID_SCOREBOARD;
        this.linkBack = IdGUI.ID_BACK;
        this.nameButtons = Arrays.asList(NameScoreboardGUI.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public IdGUI getId() {
        return this.id;
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
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    @Override
    public List<IdGUI> getLinks() {
        return List.of(this.linkBack);
    }


    public String getTitleGUI(){
        return DesignTitleGUI.TITLE_SCOREBOARD;
    }

    public IdGUI getBackLink(){
        return this.linkBack;
    }

    public List<String> getListName(){
        return this.nameButtons.stream().map(NameScoreboardGUI::getName).collect(Collectors.toList());
    }
}
