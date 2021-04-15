package model.GUI.sound;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.DesignSound;
import utilities.IdGUI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EngineSound implements EngineGUI {
    public static final String TITLE_SOUND = "SOUND";
    private final IdGUI ID = IdGUI.ID_SOUND;
    private final IdGUI idBack = IdGUI.ID_BACK;

    private List<NameSoundGUI> listNameSoundGUI;

    private int valueMainSound = DesignSound.DEFAULT_VALUE_SOUND;
    private int valueEffectSound = DesignSound.DEFAULT_VALUE_SOUND;
    private boolean stateSoundMain = true;
    private boolean stateSoundEffect = true;

    private Visibility visibility = Visibility.HIDDEN;

    public EngineSound(){
        this.listNameSoundGUI = Arrays.asList(NameSoundGUI.values());
    }

    @Override
    public IdGUI getId() {
        return ID;
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
    public List<IdGUI> getLinks() {
        return List.of(this.idBack);
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    public IdGUI getBackLink(){
        return this.idBack;
    }

    public String getTitle() {
        return TITLE_SOUND;
    }

    public List<String> getListNameComponents() {
        return listNameSoundGUI.stream().map(name -> name.getName()).collect(Collectors.toList());
    }

    public List<String> getListNameSlider(){
        return NameSoundGUI.getNameSlider();
    }

    public int getDefaultValueSound(){
        return DesignSound.DEFAULT_VALUE_SOUND;
    }

    public int getValueMainSound() {
        return valueMainSound;
    }

    public int getValueEffectSound() {
        return valueEffectSound;
    }

    public void setValueMainSound(int valueMainSound) {
        this.valueMainSound = valueMainSound;
    }

    public void setValueEffectSound(int valueEffectSound) {
        this.valueEffectSound = valueEffectSound;
    }

    public boolean getStateSoundMain() {
        return stateSoundMain;
    }

    public void setStateSoundMain(boolean stateSoundMain) {
        this.stateSoundMain = stateSoundMain;
    }

    public boolean getStateSoundEffect() {
        return stateSoundEffect;
    }

    public void setStateSoundEffect(boolean stateSoundEffect) {
        this.stateSoundEffect = stateSoundEffect;
    }
}
