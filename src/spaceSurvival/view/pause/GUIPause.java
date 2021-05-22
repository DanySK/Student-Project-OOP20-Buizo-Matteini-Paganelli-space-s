package spaceSurvival.view.pause;

import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.utilities.BtnAction;

import java.util.List;

public interface GUIPause extends GUI, GraphicsGUIPause {

    public void setNameButtons(final List<String> listNames);

    public void setIdButtons(final ActionGUI mainAction, final List<ActionGUI> linksID);

    public BtnAction getButton(final int ind);
}
