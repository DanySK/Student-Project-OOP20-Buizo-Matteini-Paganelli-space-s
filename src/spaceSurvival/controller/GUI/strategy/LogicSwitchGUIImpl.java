package spaceSurvival.controller.GUI.strategy;

import spaceSurvival.controller.GUI.ControllerGUI;
import spaceSurvival.controller.utilities.ListGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.ActionGUI;

import java.util.Map;

public class LogicSwitchGUIImpl implements LogicSwitchGUI{

    @Override
    public void algorithm(final ActionGUI actionGUI, final ListGUI<ActionGUI> listActionGUI, final Map<ActionGUI, ControllerGUI> control) {
        switch (actionGUI) {
            case ID_GAME:
                listActionGUI.add(actionGUI);
                control.get(actionGUI).turn(Visibility.VISIBLE);
                control.get(actionGUI).turn(Visibility.HIDDEN); break;

            case ID_PAUSE:
                if (listActionGUI.lastElementOfList() != ActionGUI.ID_PAUSE) {
                    listActionGUI.add(actionGUI);
                } else {
                    listActionGUI.remove(actionGUI);
                }

                control.get(actionGUI).changeVisibility(); break;

            case ID_BACK:
                control.get(actionGUI).turn(Visibility.HIDDEN);
                listActionGUI.remove(listActionGUI.lastElementOfList()); break;

            case ID_QUIT: this.quitAll(control); break;
            default:
                listActionGUI.add(actionGUI);
                control.get(actionGUI).turn(Visibility.VISIBLE); break;
        }
    }

    private void quitAll(final Map<ActionGUI, ControllerGUI> controller){
        controller.values().forEach(ControllerGUI::closeGUI);
    }
}
