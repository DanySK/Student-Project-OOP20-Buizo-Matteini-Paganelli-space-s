package model.factoryGUI.menuGUI;

import model.factoryGUI.GUIEngine;
import utilities.IdGUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuEngine implements GUIEngine {
    private final String TITLE_MENU = "SPACE-SURVIVAL";
    private final List<NameMenuGUI> nameButtons = new ArrayList<>();

    private final IdGUI ID = IdGUI.ID_MENU;
    private final List<IdGUI> linksID = new ArrayList<>();

    private boolean state = true;

    public MenuEngine(){
        Collections.addAll(this.nameButtons, NameMenuGUI.values());
        this.linksID.add(IdGUI.ID_GAME);
        this.linksID.add(IdGUI.ID_SETTING);
        this.linksID.add(IdGUI.ID_SCOREBOARD);
        this.linksID.add(IdGUI.ID_HELP);
        this.linksID.add(IdGUI.ID_QUIT);
    }

    @Override
    public String getTitleGUI(){
        return TITLE_MENU;
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
    public void changeState(){
        this.state = !state;
    }
    @Override
    public IdGUI getId() {
        return ID;
    }
    @Override
    public IdGUI getLink() {
        return null;
    }
    @Override
    public List<IdGUI> getLinks() {
        return this.linksID;
    }

    public List<NameMenuGUI> getListName(){
        return this.nameButtons;
    }

}

