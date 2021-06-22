package spacesurvival.model.gui.scoreboard;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineScoreboard implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MEDIUM;
    public static final String TITLE = "SCOREBOARD";

    private final LinkActionGUI id;
    private final LinkActionGUI linkBack;

    private final List<NameScoreboardGUI> nameButtons;

    private Visibility visibility;

    public EngineScoreboard() {
        this.id = LinkActionGUI.ID_SCOREBOARD;
        this.linkBack = LinkActionGUI.ID_BACK;
        this.nameButtons = Arrays.asList(NameScoreboardGUI.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public LinkActionGUI getMainAction() {
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
    public List<LinkActionGUI> getLinks() {
        return List.of(this.linkBack);
    }


    public String getTitleGUI(){
        return TITLE;
    }

    public LinkActionGUI getBackLink(){
        return this.linkBack;
    }

    public List<String> getListName(){
        return this.nameButtons.stream().map(NameScoreboardGUI::getName).collect(Collectors.toList());
    }
}
