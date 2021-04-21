package model.GUI.sound;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.DesignSound;
import utilities.DesignTitleGUI;
import utilities.IdGUI;
import view.GUI.sound.utilities.UnitSound;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EngineSound implements EngineGUI {
    public static int N_UNIT_SOUND = 2;
    private final IdGUI id;
    private final IdGUI idBack;

    private final List<NameUnitSound> listNameUnitSound;

    private final List<EngineUnitSound> listUnitSounds;

    private int valueMainSound;
    private int valueEffectSound;
    private StateSlider stateSoundMain;
    private StateSlider stateSoundEffect;

    private Visibility visibility;

    public EngineSound(){
        this.id = IdGUI.ID_SOUND;
        this.idBack = IdGUI.ID_BACK;

        this.listUnitSounds = Stream.generate(EngineUnitSound::new).limit(N_UNIT_SOUND)
                .collect(Collectors.toList());



        this.valueMainSound = DesignSound.DEFAULT_VALUE_SOUND;
        this.valueEffectSound = DesignSound.DEFAULT_VALUE_SOUND;
        this.stateSoundMain = StateSlider.ON;
        this.stateSoundEffect = StateSlider.ON;
        this.listNameUnitSound = Arrays.asList(NameUnitSound.values());
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public IdGUI getId() {
        return id;
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
        return List.of(this.idBack);
    }


    public String getTitle() {
        return DesignTitleGUI.TITLE_SOUND;
    }

    public IdGUI getBackLink(){
        return this.idBack;
    }

    public String getNameBack() {
        return this.idBack.getIdName();
    }

    public List<String> getListNameSlider(){
        return this.listNameUnitSound.stream().map(NameUnitSound::getNameUnitSound).collect(Collectors.toList());
    }

    public int getDefaultValueSound(){
        return DesignSound.DEFAULT_VALUE_SOUND;
    }

    public int getValueMainSound() {
        return this.valueMainSound;
    }

    public int getValueEffectSound() {
        return this.valueEffectSound;
    }

    public void setValueMainSound(int valueMainSound) {
        this.valueMainSound = valueMainSound;
    }

    public void setValueEffectSound(int valueEffectSound) {
        this.valueEffectSound = valueEffectSound;
    }

    public StateSlider getStateSoundMain() {
        return this.stateSoundMain;
    }

    public StateSlider getStateSoundEffect() {
        return this.stateSoundEffect;
    }

    public void setStateSoundMain(final StateSlider stateSoundMain) {
        this.stateSoundMain = stateSoundMain;
    }

    public void setStateSoundEffect(final StateSlider stateSoundEffect) {
        this.stateSoundEffect = stateSoundEffect;
    }

    public boolean isActiveSoundMain() {
        return this.stateSoundMain.isActive();
    }

    public boolean isActiveSoundEffect() {
        return this.stateSoundEffect.isActive();
    }

    public String actualPathStateSoundMain(){
        return this.stateSoundMain.getPath();
    }

    public String actualPathStateSoundEffect(){
        return this.stateSoundEffect.getPath();
    }

    public List<String> getActualIconStateSounds(){
        return List.of(this.stateSoundMain, this.stateSoundEffect).stream()
                .map(StateSlider::getPath)
                .collect(Collectors.toList());
    }
}
