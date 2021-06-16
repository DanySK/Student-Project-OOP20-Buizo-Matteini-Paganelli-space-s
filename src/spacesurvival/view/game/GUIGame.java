package spacesurvival.view.game;

import spacesurvival.model.World;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.game.utilities.PanelGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.util.List;

public interface GUIGame extends GUI {

    void setTimer(String timer);

    void setIdButtons(ActionGUI mainAction, List<ActionGUI> linksID);

    PanelGame getPanelGame();

    void startPaint();

    void stopPaint();

    void setWorld(World world);

    void repaintGameObjects();

    void addKeyListenerSpaceShip(KeyListener keyListener);

    void setScore(long score);

    void setRound(int round);

    void setNEnemies(long count);

    void setNHeart(int nHeart);

    void setLifeShip(int lifeShip);

    void setLifeBoss(int lifeShip);


    void setFontGUI(Font font);

    void setFontLifeBars(Font font);

    void setForegroundGUI(Color color);

    void setBackgroundLifeBars(Color color);
}
