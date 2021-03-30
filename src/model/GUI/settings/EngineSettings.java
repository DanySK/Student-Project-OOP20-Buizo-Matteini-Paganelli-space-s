package model.GUI.settings;

import model.MyJImage.JImageRateEngine;
import model.GUI.EngineGUI;
import utilities.IdGUI;

import java.util.List;

public class EngineSettings implements EngineGUI {
    private final String TITLE_SETTINGS = "SETTINGS";
    private final IdGUI ID = IdGUI.ID_SETTING;
    private final List<NameSettingsGUI> namesButtons = List.of(NameSettingsGUI.values());
    private final List<IdGUI> linksID = List.of(IdGUI.ID_BACK);

    private int chooseSkin = 0;
    private JImageRateEngine skinSpaceShip = new JImageRateEngine(SkinSpaceShip.values()[this.chooseSkin].getPath(), 12);
    private Difficult difficultState = Difficult.MEDIUM;
    private boolean state = false;

    public EngineSettings(){
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

    public List<NameSettingsGUI> getListName(){
        return this.namesButtons;
    }

    public JImageRateEngine getSkinSpaceShip() {
        return skinSpaceShip;
    }

    public Difficult getDifficultState() {
        return difficultState;
    }

    public void changeSkinDx(){
        this.chooseSkin = this.chooseSkin + 1 < SkinSpaceShip.values().length ? this.chooseSkin + 1 : 0;
        this.skinSpaceShip.setPathImg(SkinSpaceShip.values()[this.chooseSkin].getPath());
    }

    public void changeSkinSx(){
        this.chooseSkin = this.chooseSkin - 1 > -1 ? this.chooseSkin - 1 : SkinSpaceShip.values().length - 1;
        this.skinSpaceShip.setPathImg(SkinSpaceShip.values()[this.chooseSkin].getPath());
    }

    public Difficult getDifficult(){
        return this.difficultState;
    }

}
