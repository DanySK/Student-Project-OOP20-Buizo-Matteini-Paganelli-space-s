package spacesurvival.model.gui.menu;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.dimension.Screen;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implements the model for the menu GUI.
 */
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
    public static final int N_BUTTONS = LinksMenu.values().length;

    private final LinkActionGUI mainAction;
    private final List<LinksMenu> linkButtons;

    private Visibility visibility;

    /**
     * Constructor for a GUI menu model.
     */
    public EngineMenu() {
        this.mainAction = LinkActionGUI.LINK_MENU;
        this.linkButtons = Arrays.asList(LinksMenu.values());
        this.visibility = Visibility.HIDDEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkActionGUI getMainLink() {
        return this.mainAction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<LinkActionGUI> getLinks() {
        return this.linkButtons.stream()
                .map(LinksMenu::getAction)
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisibility(final Visibility visibility)  {
        this.visibility = visibility;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isVisible()  {
        return this.visibility.isVisible();
    }

    /**
     * Return the title of the menu GUI.
     * 
     * @return a string representing the menu GUI title
     */
    public String getTitleGUI() {
        return TITLE;
    }

    /**
     * Return a list of link's text.
     * 
     * @return a list of link's text.
     */
    public List<String> getListTextLinks() {
        return this.linkButtons.stream()
                .map(LinksMenu::getText)
                .collect(Collectors.toList());
    }

    /**
     * Return descriptions of menu engine.
     */
    @Override
    public String toString() {
        return "EngineMenu [mainAction=" + mainAction + ", linkButtons=" + linkButtons + ", visibility=" + visibility + "]";
    }

}

