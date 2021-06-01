package spaceSurvival.controller.GUI.strategy;

import spaceSurvival.controller.GUI.ControllerGUI;
import spaceSurvival.controller.utilities.ListGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;

import java.util.Map;

public class LogicSwitchMenu implements LogicSwitchGUI{

    @Override
    public void algorithm(final ActionGUI actionCurrent, final ActionGUI actionNext,
                          final ListGUI<ActionGUI> chronology, final Map<ActionGUI, ControllerGUI> manager) {

        switch (actionNext) {
            case ID_GAME:
                chronology.add(actionNext);
                manager.get(actionNext).turn(Visibility.VISIBLE);
                manager.get(actionCurrent).turn(Visibility.HIDDEN);
                break;

            case ID_BACK:
                manager.get(actionCurrent).turn(Visibility.HIDDEN);
                chronology.remove(chronology.lastElementOfList());
                break;

            case ID_QUIT: this.quit(); break;

            default:
                chronology.add(actionNext);
                manager.get(actionNext).turn(Visibility.VISIBLE);
                break;
        }
    }
}
