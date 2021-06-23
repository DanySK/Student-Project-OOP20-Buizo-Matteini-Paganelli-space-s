package spacesurvival.model.gui.game;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.gui.settings.SkinSpaceShip;
import spacesurvival.model.worldevent.WorldEventListener;
import spacesurvival.controller.collision.CollisionController;
import spacesurvival.model.World;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.fireable.SpaceShipSingleton;
import spacesurvival.model.gameobject.fireable.weapon.Weapon;
import spacesurvival.model.gameobject.takeable.ammo.AmmoType;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.gameobject.LifeUtils;

import java.awt.Rectangle;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EngineGame implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_FULLSCREEN;

    private final LinkActionGUI id;
    private final LinkActionGUI idPause;

    private final World world;
    private final EngineHUD hud;

    private Visibility visibility;

    public EngineGame() {
        this.id = LinkActionGUI.ID_GAME;
        this.idPause = LinkActionGUI.ID_PAUSE;
        this.world = new World(RECTANGLE);
        this.hud = new EngineHUD();
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public LinkActionGUI getMainAction() {
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
    public List<LinkActionGUI> getLinks() {
        return List.of(this.idPause);
    }

    public void setCollisionController(final CollisionController collisionController) {
        this.world.setCollisionController(collisionController);
    }

    public void setPauseAnimationAllObject(final boolean isPause) {
        this.world.setPauseAnimationAllObject(isPause);
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

    public void setSkin(final SkinSpaceShip currentSkin) {
        this.world.setSkin(currentSkin);
        
    }

    public Optional<FireableObject> getBoss() {
        return this.world.getBoss();
    }
    
    public Weapon getWeaponShip() {
        return this.getShip().getWeapon();
    }
    
    public AmmoType getAmmoTypeShip() {
        return this.getWeaponShip().getAmmoType();
    }
    
    public void assignBulletShipInHUD() {
        this.hud.setAmmoType(this.getAmmoTypeShip());
    }
    
    public AmmoType getAmmoTypeHUD() {
        return this.hud.getAmmoType();
    }
    
    public void setAmmoType(final AmmoType ammoType) {
        this.hud.setAmmoType(ammoType);
    }

}
