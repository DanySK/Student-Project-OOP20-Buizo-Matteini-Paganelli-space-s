package spaceSurvival.view.game;

import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.view.GUI;
import spaceSurvival.view.game.utilities.PanelGame;

import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.List;

public interface GUIGame extends GUI, GraphicsGUIGame {

    public void setTimer(final String timer);

    public void setIdButtons(final List<ActionGUI> linksID);

    public PanelGame getPanelGame();

    public void addGameObject(final GameObject gameObject, final AffineTransform transform);

    public void repaintGameObjects();

    public void addKeyListenerSpaceShip(final KeyListener keyListener);

    public void setScore(final long score);

    public void setRound(final int round);

    public void setNEnemies(final long count);

    public void setNHeart(final int nHeart);

    public void setLifeShip(final int lifeShip);

    public void setLifeBoss(final int lifeShip);
}
