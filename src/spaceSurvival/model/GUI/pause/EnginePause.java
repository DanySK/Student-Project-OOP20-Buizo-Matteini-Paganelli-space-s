package spaceSurvival.model.GUI.pause;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnginePause implements EngineGUI{
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MEDIUM;
    public static final String TITLE = "PAUSE";
    public static final int N_BUTTONS = 4;

    private final ActionGUI id;
    private final List<LinksPause>  linkButtons;

    private Visibility visibility;

    public EnginePause(){
        this.id = ActionGUI.ID_PAUSE;
        this.linkButtons = Arrays.asList(LinksPause.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public ActionGUI getMainAction() {
        return this.id;
    }

    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public void setVisibility(Visibility state) {
        this.visibility = state;
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    @Override
    public List<ActionGUI> getLinks() {
        return this.linkButtons.stream().map(LinksPause::getIdGUI).collect(Collectors.toList());
    }

    public String getTitleGUI(){
        return TITLE;
    }

    public List<String> getListName(){
        return this.linkButtons.stream().map(LinksPause::getName).collect(Collectors.toList());
    }
}
