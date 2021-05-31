package spaceSurvival.model.GUI.dead;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.List;

public class EngineDead implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_FULLSCREEN;
    public static final String TITLE = "GAY OVER";

    private final ActionGUI mainAction;

    private Visibility visibility;

    public EngineDead(){
        this.mainAction = ActionGUI.ID_DEAD;
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public ActionGUI getMainAction() {
        return this.mainAction;
    }

    @Override
    public Rectangle getRectangle() {
        return EngineDead.RECTANGLE;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public List<ActionGUI> getLinks() {
        return List.of();
    }

    @Override
    public void setVisibility(final Visibility state) {
        this.visibility = state;
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    public String getTitleGUI() {
        return TITLE;
    }
}
