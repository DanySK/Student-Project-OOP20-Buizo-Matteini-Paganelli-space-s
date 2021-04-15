package utilities;

import model.GUI.settings.DifficultActive;
import model.GUI.sound.StateSlider;

import java.util.List;

public class Engines {
    public static final List<DifficultActive> DEFAULT_DIFFICULTLY_ACTIVE = List.of(DifficultActive.OFF,
            DifficultActive.OFF, DifficultActive.ON);

    public static StateSlider inverseStateSlider(final StateSlider stateSlider){
        return stateSlider == StateSlider.OFF ? StateSlider.ON : StateSlider.OFF;
    }

    public static String getInversePathStateSlider(final StateSlider stateSlider){
        return stateSlider.getPath();
    }

}
