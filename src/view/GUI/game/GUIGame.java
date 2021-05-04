package view.GUI.game;

import view.GUI.GUI;
import view.GUI.game.utilities.PanelGame;
import view.spaceShip.SpaceShipView;

import java.awt.event.KeyListener;

public interface GUIGame extends GUI, GraphicsGUIGame {

    public PanelGame getPanelGame();

    public void repaintGameObjects();

    public void addKeyListenerSpaceship(final KeyListener keyListener);
}
