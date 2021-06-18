package spacesurvival.model.gui.game;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.worldevent.WorldEventListener;
import spacesurvival.model.World;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.gameobject.LifeUtils;

import java.awt.Rectangle;
import java.util.List;
import java.util.Set;

public class EngineGame implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_FULLSCREEN;
    public static final int N_BUTTONS = 6;

    private final ActionGUI id;
    private final ActionGUI idPause;

    private final World world;
    private final EngineHUD hud;

    private Visibility visibility;

    public EngineGame() {
        this.id = ActionGUI.ID_GAME;
        this.idPause = ActionGUI.ID_PAUSE;
        this.world = new World(RECTANGLE);
        this.hud = new EngineHUD();
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public ActionGUI getMainAction() {
        return this.id;
    }

    @Override
    public Rectangle getRectangle() {
        return RECTANGLE;
    }

    @Override
    public Visibility getVisibility() {
        return this.visibility;
    }

    @Override
    public void setVisibility(final Visibility state) {
        this.visibility = state;
    }

    @Override
    public boolean isVisible() {
        return this.visibility.isVisible();
    }

    @Override
    public List<ActionGUI> getLinks() {
        return List.of(this.idPause);
    }


    public String getTimer() {
        return this.hud.getTimer();
    }

    public void startTimer() {
        this.hud.startTimer();
    }

    public void stopTimer() {
        this.hud.stopTimer();
    }

    public long getScore() {
        return this.hud.getScore();
    }

    public int getRound() {
        return this.hud.getRound();
    }

    public long getCountEnemies() {
        return this.world.getCountEnemies();
    }

    public int getLives() {
        return this.hud.getLives();
    }

    public int getLifeShip() {
        return this.world.getLifeShip();
    }

    public int getLifeBoss() {
        return this.world.getLifeBoss();
    }

    public void incrScore(final long score) {
        this.hud.incrScore(score);
    }

    public void incrRound() {
        this.hud.incrRound();
    }

    public void decreaseLifeShip(final int damage) {
        this.world.getShip().decreaseLife(damage);
    }

    public void decreaseLives() {
        this.hud.decreaseLives();
    }

    public void increaseLives(final int amount) {
        this.hud.increaseLives(amount);
    }

//    public boolean hasLostLife() {
//        return this.getLives() == 0;
//    }

    public void setLifeShip(final int life) {
        this.world.getShip().setLife(life);
    }

    public void resetLifeShip() {
        this.world.getShip().setLife(LifeUtils.SPACESHIP_LIFE);
    }

    public boolean isGameOver() {
        return this.getLives() <= 0 && this.getLifeShip() <= 0;
    }

    public World getWorld() {
        return this.world;
    }

    public void restartGame() {
        this.resetLifeShip();
        this.hud.resetLives();
        this.hud.resetTimer();
    }

    public Set<GameObject> getAllObjects() {
        return this.world.getAllObjects();
    }

    public SpaceShipSingleton getShip() {
        return this.world.getShip();
    }

    public void setEventListenerInWorld(final WorldEventListener worldEventListener) {
        this.world.setEventListener(worldEventListener);
    }

    public void updateStateWorld() {
        this.world.updateState();
    }

}
