package spacesurvival.model.gui.sound;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EngineMixerSound {
    private final List<TypeUnitSound> listTypeUnitSound;
    private final Map<TypeUnitSound, EngineUnitSound> mapUnit;

    public EngineMixerSound(final List<TypeUnitSound> nameUnit){
        this.listTypeUnitSound = nameUnit;
        this.mapUnit = new HashMap<>();
        this.listTypeUnitSound.forEach(name -> this.mapUnit.put(name, new EngineUnitSound()));
    }

    public int getValueSound(final TypeUnitSound typeUnitSound){
        return this.mapUnit.get(typeUnitSound).getValueSound();
    }

    public void setValueSound(final TypeUnitSound typeUnitSound, final int valueUnit){
        this.mapUnit.get(typeUnitSound).setValueSound(valueUnit);
    }

    public StateSlider getStateSound(final TypeUnitSound typeUnitSound){
        return this.mapUnit.get(typeUnitSound).getStateSlider();
    }

    public void setStateSound(final TypeUnitSound typeUnitSound, final StateSlider stateUnit){
        this.mapUnit.get(typeUnitSound).setStateSlider(stateUnit);
    }

    public String getPathIconState(final TypeUnitSound typeUnitSound){
        return this.mapUnit.get(typeUnitSound).getPathIconState();
    }

    public void changeStateSound(final TypeUnitSound typeUnitSound){
        final StateSlider state = this.mapUnit.get(typeUnitSound).getStateSlider();
        this.mapUnit.get(typeUnitSound).setStateSlider(state == StateSlider.OFF ? StateSlider.ON : StateSlider.OFF);
    }

    public boolean isActiveSound(final TypeUnitSound typeUnitSound){
        return this.mapUnit.get(typeUnitSound).isActiveSlider();
    }

    public List<TypeUnitSound> getListTypeUnitsSound(){
        return this.listTypeUnitSound;
    }

    public List<String> getNameUnitsSound(){
        return this.listTypeUnitSound.stream().map(TypeUnitSound::getNameUnitSound).collect(Collectors.toList());
    }

    public List<String> getPathsIconState(){
        return this.listTypeUnitSound.stream()
                .map(this.mapUnit::get)
                .map(EngineUnitSound::getPathIconState)
                .collect(Collectors.toList());
    }

}
