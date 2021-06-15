package view.game;

import model.World;
import utilities.ActionGUI;
import view.GUI;
import view.game.utilities.PanelGame;

import java.awt.event.KeyListener;
import java.util.List;

public interface GUIGame extends GUI, GraphicsGUIGame {

    public void setTimer(final String timer);

    public void setIdButtons(final ActionGUI mainAction, final List<ActionGUI> linksID);

    public PanelGame getPanelGame();

    public void startPaint();

    public void stopPaint();

    public void setWorld(final World world);

    public void repaintGameObjects();

    public void addKeyListenerSpaceShip(final KeyListener keyListener);

    public void setScore(final long score);

    public void setRound(final int round);

    public void setNEnemies(final long count);

    public void setNHeart(final int nHeart);

    public void setLifeShip(final int lifeShip);

    public void setLifeBoss(final int lifeShip);


}
