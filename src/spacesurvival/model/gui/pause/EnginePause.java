package spacesurvival.model.gui.pause;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnginePause implements EngineGUI{
    /**
     * Dimension of the pause GUI.
     */
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MINI;
    /**
     * Dimension of the pause GUI.
     */
    public static final String TITLE = "PAUSE";
    /**
     * Dimension of the pause GUI.
     */
    public static final int N_BUTTONS = 4;

    private final LinkActionGUI mainAction;
    private final List<LinksPause>  linkButtons;

    private Visibility visibility;

    public EnginePause(){
        this.mainAction = LinkActionGUI.ID_PAUSE;
        this.linkButtons = Arrays.asList(LinksPause.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public LinkActionGUI getMainLink() {
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
    public void setVisibility(final Visibility state) {
        this.visibility = state;
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    @Override
    public List<LinkActionGUI> getLinks() {
        return this.linkButtons.stream().map(LinksPause::getIdGUI).collect(Collectors.toList());
    }


    public String getTitleGUI(){
        return TITLE;
    }

    public List<String> getListName(){
        return this.linkButtons.stream().map(LinksPause::getName).collect(Collectors.toList());
    }


}
