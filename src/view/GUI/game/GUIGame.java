package view.GUI.game;

import utilities.IdGUI;
import view.GUI.GUI;
import view.GUI.game.utilities.PanelGame;
import view.spaceShip.SpaceShipView;

import java.awt.event.KeyListener;
import java.util.List;

public interface GUIGame extends GUI, GraphicsGUIGame {

    public void setIdButtons(final List<IdGUI> linksID);

    public PanelGame getPanelGame();

    public void repaintGameObjects();

    public void addKeyListenerSpaceship(final KeyListener keyListener);
}
