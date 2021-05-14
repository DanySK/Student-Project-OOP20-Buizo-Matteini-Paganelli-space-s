package model.GUI.pause;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.DesignTitleGUI;
import utilities.IdGUI;
import utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnginePause implements EngineGUI{

    public static final Rectangle DIMENSION = Screen.RECTANGLE_MEDIUM;
    public static final int N_BUTTONS = 4;

    private final IdGUI id;
    private final List<LinksPause>  linkButtons;

    private Visibility visibility;

    public EnginePause(){
        this.id = IdGUI.ID_PAUSE;
        this.linkButtons = Arrays.asList(LinksPause.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public IdGUI getId() {
        return this.id;
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
    public List<IdGUI> getLinks() {
        return this.linkButtons.stream().map(LinksPause::getIdGUI).collect(Collectors.toList());
    }

    public String getTitleGUI(){
        return DesignTitleGUI.TITLE_PAUSE;
    }

    public List<String> getListName(){
        return this.linkButtons.stream().map(LinksPause::getName).collect(Collectors.toList());
    }
}
