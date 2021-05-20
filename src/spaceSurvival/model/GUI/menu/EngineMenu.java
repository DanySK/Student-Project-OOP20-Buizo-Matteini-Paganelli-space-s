package spaceSurvival.model.GUI.menu;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.DesignTitleGUI;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineMenu implements EngineGUI {
    public static final Rectangle DIMENSION = Screen.RECTANGLE_FULLSCREEN;

    private final IdGUI id;
    private final List<LinksMenu> linkButtons;

    private Visibility visibility;

    public EngineMenu(){
        this.id = IdGUI.ID_MENU;
        this.linkButtons = Arrays.asList(LinksMenu.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public IdGUI getId() {
        return this.id;
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
    public List<IdGUI> getLinks() {
        return this.linkButtons.stream().map(LinksMenu::getIdGUI).collect(Collectors.toList());
    }


    public String getTitleGUI(){
        return DesignTitleGUI.TITLE_MENU;
    }

    public List<String> getListName(){
        return this.linkButtons.stream().map(LinksMenu::getName).collect(Collectors.toList());
    }

}

