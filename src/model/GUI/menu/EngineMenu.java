package model.GUI.menu;

import model.GUI.EngineGUI;
import utilities.IdGUI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineMenu implements EngineGUI {
    public final static String TITLE_MENU = "SPACE-SURVIVAL";
    private final IdGUI ID = IdGUI.ID_MENU;
    private final List<LinksMenu> linkButtons;

    private boolean state = true;

    public EngineMenu(){
        this.linkButtons = Arrays.asList(LinksMenu.values());
    }

    @Override
    public boolean getState(){
        return this.state;
    }
    @Override
    public void setState(boolean state) {
        this.state = state;
    }
    @Override
    public IdGUI getId() {
        return ID;
    }
    @Override
    public List<IdGUI> getLinks() {
        return this.linkButtons.stream().map(l -> l.getIdGUI()).collect(Collectors.toList());
    }


    public String getTitleGUI(){
        return TITLE_MENU;
    }

    public List<String> getListName(){
        return this.linkButtons.stream().map(l -> l.getName()).collect(Collectors.toList());
    }

}

