package spaceSurvival.model.GUI.dead;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.GUI.menu.LinksMenu;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.utilities.dimension.Screen;

import javax.security.auth.login.AccountNotFoundException;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class EngineDead implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_FULLSCREEN;
    public static final String TITLE = "GAME OVER";
    public static final int N_BUTTONS = 2;

    private final ActionGUI mainAction;
    private final List<LinksDead> linkButtons;

    private Visibility visibility;

    public EngineDead(){
        this.mainAction = ActionGUI.ID_DEAD;
        
        this.linkButtons = Arrays.asList(LinksDead.values());
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
