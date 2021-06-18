package spacesurvival.model.gui.menu;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.utilities.dimension.Screen;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineMenu implements EngineGUI {
    /**
     * Dimension of the menu GUI.
     */
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_FULLSCREEN;
    /**
     * Title of the menu GUI.
     */
    public static final String TITLE = "SPACE SURVIVAL";
    /**
     * Number of buttons of the menu GUI.
     */
    public static final int N_BUTTONS = 6;

    private final ActionGUI mainAction;
    private final List<LinksMenu> linkButtons;

    private Visibility visibility;

    public EngineMenu() {
        this.mainAction = ActionGUI.ID_MENU;
        this.linkButtons = Arrays.asList(LinksMenu.values());
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
    public List<ActionGUI> getLinks() {
        return this.linkButtons.stream()
                .map(LinksMenu::getAction)
                .collect(Collectors.toList());
    }

    @Override
    public void setVisibility(final Visibility visibility)  {
        this.visibility = visibility;
    }

    @Override
    public boolean isVisible()  {
        return this.visibility.isVisible();
    }

    /**
     * Return the title of the menu gui.
     * 
     * @return a string representing the menu GUI title
     */
    public String getTitleGUI() {
        return TITLE;
    }

    /**
     * Return a list of link's name.
     * 
     * @return a list of link's name
     */
    public List<String> getListNameLinks() {
        return this.linkButtons.stream()
                .map(LinksMenu::getName)
                .collect(Collectors.toList());
    }
}

