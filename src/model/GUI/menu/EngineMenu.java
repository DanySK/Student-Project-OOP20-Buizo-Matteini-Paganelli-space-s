package model.GUI.menu;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.IdGUI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineMenu implements EngineGUI {
    public final static String TITLE_MENU = "SPACE-SURVIVAL";
    private final IdGUI ID = IdGUI.ID_MENU;
    private final List<LinksMenu> linkButtons;

    private Visibility visibility = Visibility.VISIBLE;

    public EngineMenu(){
        this.linkButtons = Arrays.asList(LinksMenu.values());
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
    public IdGUI getId() {
        return ID;
    }
    @Override
    public List<IdGUI> getLinks() {
        return this.linkButtons.stream().map(l -> l.getIdGUI()).collect(Collectors.toList());
    }
    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }



    public String getTitleGUI(){
        return TITLE_MENU;
    }

    public List<String> getListName(){
        return this.linkButtons.stream().map(l -> l.getName()).collect(Collectors.toList());
    }

}

