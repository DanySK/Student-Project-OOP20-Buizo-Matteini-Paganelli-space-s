package spacesurvival.view.game;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.takeable.ammo.AmmoType;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.game.utilities.PanelBulletGame;
import spacesurvival.view.game.utilities.PanelEntityGame;
import spacesurvival.view.utilities.GraphicsText;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.util.List;

public interface GUIGame extends GUI, GraphicsText {

    void setMaxLifeShip(int maxLife);

    void setMaxLifeBoss(int maxBoss);

    void setBulletHUD(AmmoType ammoType);

    void setVisibleLifeBarBoss(boolean visible);

    void setTimer(String timer);

    void setBoundsGame(Rectangle rectangle);

    void setIdButtons(LinkActionGUI mainAction, List<LinkActionGUI> linksID);

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

    void setLifeBoss(int lifeBoss);

    void setFontLifeBars(Font font);

    void setBackgroundLifeBars(Color color);
}
