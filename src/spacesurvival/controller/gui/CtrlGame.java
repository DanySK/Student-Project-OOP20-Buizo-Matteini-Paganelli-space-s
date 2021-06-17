package spacesurvival.controller.gui;

import spacesurvival.controller.gui.command.SwitchGUI;
import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.gui.game.EngineGame;
import spacesurvival.model.worldevent.WorldEventListener;
import spacesurvival.model.World;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.MovementKeyListener;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.GUI;
import spacesurvival.view.game.GUIGame;

import java.awt.event.KeyListener;

public class CtrlGame implements ControllerGUI {
    private final EngineGame engine;
    private final GUIGame gui;

    private final SwitchGUI switchGUI;

    public CtrlGame(final EngineGame engine, final GUIGame gui){
        this.engine = engine;
        this.gui = gui;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);

        this.assignAction();
        this.assignStrings();
        this.assignRectangle();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    @Override
    public final void assignAction() {
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setIdButtons(this.engine.getMainAction(), this.engine.getLinks());
    }

    @Override
    public final void assignStrings() {
        this.updateHUD();
        this.gui.setMaxLifeBoss(GameObjectUtils.BOSS_LIFE);
        this.gui.setMaxLifeShip(GameObjectUtils.SPACESHIP_LIFE);
    }

    @Override
    public final void assignRectangle() {
        this.gui.setBoundsGame(this.engine.getRectangle());
    }

    @Override
    public final ActionGUI getMainAction() {
        return this.engine.getMainAction();
    }

    @Override
    public final GUI getGUI() {
        return this.gui;
    }

    @Override
    public final EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public final boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public final void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public final void changeVisibility() {
        this.switchGUI.changeVisibility();
    }

    @Override
    public final void closeGUI() {
        this.gui.close();
    }

    public final void updateHUD() {
        this.gui.setTimer(this.engine.getTimer());
        this.gui.setScore(this.engine.getScore());
        this.gui.setRound(this.engine.getRound());
        this.gui.setNEnemies(this.engine.getCountEnemies());
        this.gui.setNHeart(this.engine.getLives());
        this.gui.setLifeShip(this.engine.getLifeShip());
        if (this.getWorld().getBoss().isPresent()) {
            this.gui.setLifeBoss(this.engine.getLifeBoss());
        } else {
            this.setVisibleLifeBarBoss(false);
        }
    }

    public final void updateRoundState() {
        if (this.engine.getCountEnemies() == 0) {
            System.out.println("finiti nemici, incremento round");
            this.engine.incrRound();
            this.resetEntities();
            this.engine.getWorld().getBoss().ifPresent(boss -> this.setVisibleLifeBarBoss(true));
        }
    }
    
    public void setVisibleLifeBarBoss(final boolean visible) {
        this.gui.setVisibleLifeBarBoss(visible);
    }

    public final void resetEntities() {
        this.getWorld().removeAllEnemies();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addAsteroid();
        this.getWorld().addChaseEnemy();
        this.getWorld().addFireEnemy();
        this.getWorld().addBoss();
        System.out.println(this.getWorld().getAllEntities());
	}

    public final void assignWorld() {
        this.gui.setWorld(this.engine.getWorld());
        this.engine.getWorld().getBoss().ifPresent(boss -> this.setVisibleLifeBarBoss(true));
    }


    public final void startTimer() {
        this.engine.startTimer();
    }

    public final void stopTimer() {
        this.engine.stopTimer();
    }

    public final World getWorld() {
		return this.engine.getWorld();
	}

    public final SpaceShipSingleton getShip() {
        return this.engine.getShip();
    }

    public final void setEventListenerInWorld(final WorldEventListener worldEventListener) {
        this.engine.setEventListenerInWorld(worldEventListener);
    }

    private MovementKeyListener getMovementKeyListener(){
        return new MovementKeyListener(this.engine.getShip());
    }

    public final void assignMovementListenerInShip(){
        this.addKeyListenerShip(this.getMovementKeyListener());
    }

    public final boolean isGameOver(){
        return this.engine.isGameOver();
    }

    public final void restartGame(){
        this.engine.restartGame();
    }

    public final void decreaseLife(final int damage) {
        final int effectDamage = this.damageOverFlow(damage) ? this.engine.getLifeShip() : damage;

        if (this.damageOverFlow(damage)) {
            if (this.hasLivesShip()) {
                this.engine.resetLifeShip();
            }
            this.engine.decreaseLives();
        }

        this.engine.decreaseLifeShip(effectDamage);

        if (this.hasLivesShip() && this.engine.getLifeShip() == 0) {
            this.engine.decreaseLives();
            this.engine.resetLifeShip();
        }
    }

    public final void increaseLife(final int healAmount) {
        this.getShip().increaseLife(healAmount);
    }

    public final void increaseLives(final int amount) {
        this.engine.increaseLives(amount);
    }

    private boolean damageOverFlow(final int damage) {
        return this.engine.getLifeShip() - damage < 0;
    }

    private boolean hasLivesShip() {
        return this.engine.getLives() > 1;
    }

    public final void repaintWorld() {
        this.gui.repaintGameObjects();
    }

    public final void incrScore(final long score) {
        this.engine.incrScore(score);
    }

    public void updateStateWorld() {
        this.engine.updateStateWorld();
    }

    private void addKeyListenerShip(final KeyListener keyListener) {
        this.gui.addKeyListenerSpaceShip(keyListener);
    }

}
