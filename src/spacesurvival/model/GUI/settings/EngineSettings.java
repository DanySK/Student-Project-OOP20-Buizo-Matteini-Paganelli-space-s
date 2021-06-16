package spacesurvival.model.GUI.settings;

import spacesurvival.model.GUI.Visibility;
import spacesurvival.model.EngineImage;
import spacesurvival.model.GUI.EngineGUI;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.ActionGUI;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EngineSettings implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_MEDIUM;
    public static final String TITLE = "SETTING";

    public static final String DIR_SX = "<";
    public static final String DIR_DX = ">";
    public static final int INDEX_INIT_SKIN = 0;
    public static final int STEP_INDEX_SKIN = 1;

    public static final int INDEX_INTI_DIFFICULT = 0;
    public static final int FIRST_DIFFICULT_ON = 0;
    public static final List<StateDifficult> DEFAULT_DIFFICULTLY_ACTIVE = List.of(StateDifficult.OFF,
            StateDifficult.ON, StateDifficult.OFF);

    private final ActionGUI mainAction;
    private final ActionGUI actionBack;
    private final List<UnitSettingsGUI> unitNames;

    private final List<SkinSpaceShip> listSkin;
    private final EngineImage skin;
    private int chooseSkin;

    private final Map<Difficulty, StateDifficult> difficult;

    private Visibility visibility = Visibility.HIDDEN;

    public EngineSettings(){
        this.mainAction = ActionGUI.ID_SETTING;
        this.actionBack = ActionGUI.ID_BACK;

        this.listSkin = Arrays.asList(SkinSpaceShip.values());
        this.chooseSkin = INDEX_INIT_SKIN;
        this.skin = new EngineImage(ScaleOf.ICON_SKIN, (int) RECTANGLE.getWidth(), this.listSkin.get(chooseSkin).getSkin());

        this.unitNames = List.of(UnitSettingsGUI.values());

        this.difficult = IntStream.range(INDEX_INTI_DIFFICULT, Difficulty.values().length).boxed()
                .collect(Collectors.toMap(i -> Difficulty.values()[i], DEFAULT_DIFFICULTLY_ACTIVE::get));
    }

    @Override
    public ActionGUI getMainAction() {
        return this.mainAction;
    }

    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
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
    public List<ActionGUI> getLinks() {
        return List.of(this.actionBack);
    }


    public List<Difficulty> getListDifficult(){
        return Arrays.asList(Difficulty.values());
    }

    public ActionGUI getBackLink(){
        return this.actionBack;
    }

    public String getTitleGUI() {
        return TITLE;
    }

    public List<String> getListNameUnit(){
        return this.unitNames.stream().map(UnitSettingsGUI::getTitle).collect(Collectors.toList());
    }

    public String getNameBtnBack(){
        return this.actionBack.getIdName();
    }

    public SkinSpaceShip getSkinShip(){
        return this.listSkin.get(this.chooseSkin);
    }

    public EngineImage getEngineSkinShip() {
        this.skin.setPath(this.listSkin.get(this.chooseSkin).getSkin());
        return this.skin;
    }

    public void changeSkinDx(){
        this.chooseSkin = this.chooseSkin + STEP_INDEX_SKIN < SkinSpaceShip.values().length ?
                this.chooseSkin + STEP_INDEX_SKIN : INDEX_INIT_SKIN;
    }

    public void changeSkinSx(){
        this.chooseSkin = this.chooseSkin - STEP_INDEX_SKIN >= INDEX_INIT_SKIN ?
                this.chooseSkin - STEP_INDEX_SKIN : SkinSpaceShip.values().length - STEP_INDEX_SKIN;
    }

    public Difficulty getDifficultActivate(){
        return this.difficult.entrySet().stream()
                .filter(e -> e.getValue().equals(StateDifficult.ON))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(FIRST_DIFFICULT_ON);
    }

    public void setDifficult(final Difficulty difficultyState) {
        this.resetDifficultlyOFF();
        this.difficult.entrySet().stream()
                .filter(e -> e.getKey().equals(difficultyState))
                .forEach(e -> e.setValue(StateDifficult.ON));
    }

    private void resetDifficultlyOFF(){
        this.difficult.entrySet().forEach(e -> e.setValue(StateDifficult.OFF));
    }
}
