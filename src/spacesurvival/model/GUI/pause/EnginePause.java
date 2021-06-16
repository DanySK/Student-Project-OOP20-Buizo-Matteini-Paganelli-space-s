package spacesurvival.model.GUI.pause;

import spacesurvival.model.GUI.EngineGUI;
import spacesurvival.model.GUI.Visibility;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnginePause implements EngineGUI{
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MINI;
    public static final String TITLE = "PAUSE";
    public static final int N_BUTTONS = 4;

    private final ActionGUI mainAction;
    private final List<LinksPause>  linkButtons;

    private Visibility visibility;

    public EnginePause(){
        this.mainAction = ActionGUI.ID_PAUSE;
        this.linkButtons = Arrays.asList(LinksPause.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public ActionGUI getMainAction() {
        return this.mainAction;
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
