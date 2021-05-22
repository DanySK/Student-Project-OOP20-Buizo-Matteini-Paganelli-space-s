package spaceSurvival.model.GUI.scoreboard;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineScoreboard implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MEDIUM;
    public static String TITLE = "SCOREBOARD";

    private final ActionGUI id;
    private final ActionGUI linkBack;

    private final List<NameScoreboardGUI> nameButtons;

    private Visibility visibility;

    public EngineScoreboard() {
        this.id = ActionGUI.ID_SCOREBOARD;
        this.linkBack = ActionGUI.ID_BACK;
        this.nameButtons = Arrays.asList(NameScoreboardGUI.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public ActionGUI getActionGUI() {
        return this.id;
    }

    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
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
    public List<ActionGUI> getLinks() {
        return List.of(this.linkBack);
    }


    public String getTitleGUI(){
        return TITLE;
    }

    public ActionGUI getBackLink(){
        return this.linkBack;
    }

    public List<String> getListName(){
        return this.nameButtons.stream().map(NameScoreboardGUI::getName).collect(Collectors.toList());
    }
}
