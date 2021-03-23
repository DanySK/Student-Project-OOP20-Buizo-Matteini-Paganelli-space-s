package model.factoryGUI.settingsGUI;

import model.factoryGUI.GUIEngine;
import utilities.IdGUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SettingsEngine implements GUIEngine {
    private final String TITLE_SETTINGS = "SETTINGS";
    private final List<NameSettigsGUI> namesButtons = new ArrayList<>();

    private final IdGUI ID = IdGUI.ID_SETTING;
    private final List<IdGUI> linksID = new ArrayList<>();

    private boolean state = false;

    public SettingsEngine(){
        Collections.addAll(this.namesButtons, NameSettigsGUI.values());
        this.linksID.add(IdGUI.ID_BACK);
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    @Override
    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public void changeState() {
        this.state = !state;
    }

    @Override
    public IdGUI getId() {
        return this.ID;
    }

    @Override
    public IdGUI getLink() {
        return this.linksID.get(0);
    }

    @Override
    public List<IdGUI> getLinks() {
        return this.linksID;
    }

    @Override
    public String getTitleGUI() {
        return TITLE_SETTINGS;
    }

    public List<NameSettigsGUI> getListName(){
        return this.namesButtons;
    }
}
