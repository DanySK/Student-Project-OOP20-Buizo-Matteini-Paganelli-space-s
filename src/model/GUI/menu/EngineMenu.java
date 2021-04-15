package model.GUI.menu;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.DesignTitleGUI;
import utilities.IdGUI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineMenu implements EngineGUI {
    private final IdGUI id;
    private final List<LinksMenu> linkButtons;

    private Visibility visibility;

    public EngineMenu(){
        this.id = IdGUI.ID_MENU;
        this.linkButtons = Arrays.asList(LinksMenu.values());
        this.visibility = Visibility.VISIBLE;
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

