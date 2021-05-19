package spaceSurvival.view.GUI.game;

import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.GUI;
import spaceSurvival.view.GUI.game.utilities.PanelGame;

import java.awt.event.KeyListener;
import java.util.List;

public interface GUIGame extends GUI, GraphicsGUIGame {

    public void setTimer(final String timer);

    public void setIdButtons(final List<IdGUI> linksID);

    public PanelGame getPanelGame();

    public void repaintGameObjects();

    public void addKeyListenerSpaceship(final KeyListener keyListener);
}
