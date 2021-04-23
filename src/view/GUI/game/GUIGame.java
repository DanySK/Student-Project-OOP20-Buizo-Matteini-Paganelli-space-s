package view.GUI.game;

import view.GUI.GUI;
import view.spaceShip.SpaceShipView;

import java.awt.event.KeyListener;

public interface GUIGame extends GUI, GraphicsGUIGame {
    public SpaceShipView getSpaceship();

    public void addKeyListenerSpaceship(final KeyListener keyListener);
}
