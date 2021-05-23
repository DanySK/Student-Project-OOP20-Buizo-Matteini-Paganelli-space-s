package spaceSurvival.view.pause;

import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.utilities.BtnAction;

import java.util.List;

public interface GUIPause extends GUI, GraphicsGUIPause {

    public BtnAction getActionBtn(final int ind);

    public void setNameButtons(final List<String> listNames);

    public void setActionButtons(final ActionGUI mainAction, final List<ActionGUI> linksID);

}
