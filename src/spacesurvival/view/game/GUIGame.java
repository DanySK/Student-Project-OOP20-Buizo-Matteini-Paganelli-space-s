package spacesurvival.view.game;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.takeable.AmmoType;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.game.utilities.PanelBulletGame;
import spacesurvival.view.game.utilities.PanelEntityGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.util.List;

public interface GUIGame extends GUI {
    
    void setMaxLifeShip(int maxLife);
    
    void setMaxLifeBoss(int maxLife);

    void setBulletHUD(AmmoType ammoType);
    
    void setVisibleLifeBarBoss(final boolean visible);
    
    void setBoundsGame(Rectangle screen);

    void setTimer(String timer);

    void setIdButtons(ActionGUI mainAction, List<ActionGUI> linksID);

    PanelEntityGame getPanelEntity();

    PanelBulletGame getPanelBullet();

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
