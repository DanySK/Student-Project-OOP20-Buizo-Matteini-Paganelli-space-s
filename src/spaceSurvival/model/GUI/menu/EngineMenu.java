package spaceSurvival.model.GUI.menu;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineMenu implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_FULLSCREEN;
    public static final String TITLE = "SPACE SURVMALA";
    public static final int N_BUTTONS = 6;

    private final ActionGUI actionId;
    private final List<LinksMenu> linkButtons;

    private Visibility visibility;

    public EngineMenu(){
        this.actionId = ActionGUI.ID_MENU;
        this.linkButtons = Arrays.asList(LinksMenu.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public ActionGUI getActionGUI()  {
        return this.actionId;
    }

    @Override
    public Rectangle getRectangle()  {
        return RECTANGLE;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public List<ActionGUI> getLinks() {
        return this.linkButtons.stream()
                .map(LinksMenu::getIdGUI)
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


    public String getTitleGUI() {
        return TITLE;
    }

    public List<String> getListName() {
        return this.linkButtons.stream()
                .map(LinksMenu::getName)
                .collect(Collectors.toList());
    }

}

