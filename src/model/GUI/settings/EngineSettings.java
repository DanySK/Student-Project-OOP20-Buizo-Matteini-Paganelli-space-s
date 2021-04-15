package model.GUI.settings;

import model.GUI.Visibility;
import model.MyJImage.JImageRateEngine;
import model.GUI.EngineGUI;
import utilities.IdGUI;

import java.security.KeyStore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EngineSettings implements EngineGUI {
    private final String TITLE_SETTINGS = "SETTINGS";
    private final IdGUI ID = IdGUI.ID_SETTING;
    private final List<NameSettingsGUI> namesButtons = List.of(NameSettingsGUI.values());
    private final List<IdGUI> linksID = List.of(IdGUI.ID_BACK);

    private int chooseSkin = 3;
    private JImageRateEngine skinSpaceShip = new JImageRateEngine(SkinSpaceShip.values()[this.chooseSkin].getPath(),15);
    private Map<Difficult, Boolean> difficult = new HashMap<>();

    private Visibility visibility = Visibility.HIDDEN;

    public EngineSettings(){
        this.difficult.put(Difficult.EASY, false);
        this.difficult.put(Difficult.MEDIUM, true);
        this.difficult.put(Difficult.HARD, false);
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public void setVisibility(final Visibility visibility) {
        this.visibility = visibility;
    }

    @Override
    public IdGUI getId() {
        return this.ID;
    }

    @Override
    public List<IdGUI> getLinks() {
        return this.linksID;
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    public IdGUI getBackLink(){
        return this.linksID.get(0);
    }


    public String getTitleGUI() {
        return TITLE_SETTINGS;
    }

    public List<NameSettingsGUI> getListName(){
        return this.namesButtons;
    }

    public JImageRateEngine getSkinSpaceShip() {
        return skinSpaceShip;
    }

    public void changeSkinDx(){
        this.chooseSkin = this.chooseSkin + 1 < SkinSpaceShip.values().length ? this.chooseSkin + 1 : 0;
        this.skinSpaceShip.setPathImg(SkinSpaceShip.values()[this.chooseSkin].getPath());
    }

    public void changeSkinSx(){
        this.chooseSkin = this.chooseSkin - 1 > -1 ? this.chooseSkin - 1 : SkinSpaceShip.values().length - 1;
        this.skinSpaceShip.setPathImg(SkinSpaceShip.values()[this.chooseSkin].getPath());
    }

    public Difficult getDifficultActivate(){
        return this.difficult.entrySet().stream().filter(e -> e.getValue().equals(true))
                .map(e -> e.getKey())
                .collect(Collectors.toList()).get(0);
    }

    public Map<Difficult, Boolean> getDifficult() {
        return this.difficult;
    }

    public void setDifficult(final Difficult difficultState) {
        this.difficult.entrySet().forEach(e -> e.setValue(false));

        this.difficult.entrySet().stream()
                .filter(e -> e.getKey().equals(difficultState))
                .forEach(e -> e.setValue(true));
    }
//
//    public int getSoundBackground() {
//        return this.soundBackground;
//    }
//
//    public int getSoundEffect() {
//        return this.soundEffect;
//    }
//
//    public void setSoundBackground(int soundBackground) {
//        this.soundBackground = soundBackground;
//    }
//
//    public void setSoundEffect(int soundEffect) {
//        this.soundEffect = soundEffect;
//    }
}
