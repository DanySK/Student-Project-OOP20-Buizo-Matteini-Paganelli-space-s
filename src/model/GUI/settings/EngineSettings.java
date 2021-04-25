package model.GUI.settings;

import model.GUI.Visibility;
import model.image.EngineImage;
import model.GUI.EngineGUI;
import utilities.DesignImage;
import utilities.DesignTitleGUI;
import utilities.Engines;
import utilities.IdGUI;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EngineSettings implements EngineGUI {
    public static final int INDEX_INIT_SKIN = 0;
    public static final int INDEX_INTI_DIFFICULT = 0;
    public static final int STEP_INDEX_SKIN = 1;
    public static final int FIRST_DIFFICULT_ON = 0;

    private final IdGUI id;
    private final List<NameSettingsGUI> namesButtons;
    private final IdGUI linkBack;

    private final Map<Difficulty, DifficultActive> difficult;
    private final EngineImage skinSpaceShip;
    private int chooseSkin;

    private Visibility visibility = Visibility.HIDDEN;

    public EngineSettings(){
        this.id = IdGUI.ID_SETTING;
        this.linkBack = IdGUI.ID_BACK;
        this.chooseSkin = INDEX_INIT_SKIN;
        this.skinSpaceShip = new EngineImage(SkinSpaceShip.values()[this.chooseSkin].getPath(),
                DesignImage.RATE_ICON_SKIN);
        this.namesButtons = List.of(NameSettingsGUI.values());

        this.difficult = IntStream.range(INDEX_INTI_DIFFICULT, Difficulty.values().length).boxed()
                .collect(Collectors.toMap(i -> Difficulty.values()[i], Engines.DEFAULT_DIFFICULTLY_ACTIVE::get));
    }

    @Override
    public IdGUI getId() {
        return this.id;
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
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    @Override
    public List<IdGUI> getLinks() {
        return List.of(this.linkBack);
    }


    public IdGUI getBackLink(){
        return this.linkBack;
    }

    public String getTitleGUI() {
        return DesignTitleGUI.TITLE_SETTINGS;
    }

    public List<String> getListNameUnit(){
        return this.namesButtons.stream().map(NameSettingsGUI::getTitle).collect(Collectors.toList());
    }

    public String getNameBtnBack(){
        return this.linkBack.getIdName();
    }

    public EngineImage getSkinSpaceShip() {
        return this.skinSpaceShip;
    }

    public void changeSkinDx(){
        this.chooseSkin = this.chooseSkin + STEP_INDEX_SKIN < SkinSpaceShip.values().length ?
                this.chooseSkin + STEP_INDEX_SKIN : INDEX_INIT_SKIN;
        this.skinSpaceShip.setPath(SkinSpaceShip.values()[this.chooseSkin].getPath());
    }

    public void changeSkinSx(){
        this.chooseSkin = this.chooseSkin - STEP_INDEX_SKIN >= INDEX_INIT_SKIN ?
                this.chooseSkin - STEP_INDEX_SKIN : SkinSpaceShip.values().length - STEP_INDEX_SKIN;
        this.skinSpaceShip.setPath(SkinSpaceShip.values()[this.chooseSkin].getPath());
    }

    public Difficulty getDifficultActivate(){
        return this.difficult.entrySet().stream()
                .filter(e -> e.getValue().equals(DifficultActive.ON))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(FIRST_DIFFICULT_ON);
    }

    public void setDifficult(final Difficulty difficultyState) {
        this.resetDifficultlyOFF();
        this.difficult.entrySet().stream()
                .filter(e -> e.getKey().equals(difficultyState))
                .forEach(e -> e.setValue(DifficultActive.ON));
    }

    private void resetDifficultlyOFF(){
        this.difficult.entrySet().forEach(e -> e.setValue(DifficultActive.OFF));
    }
}
