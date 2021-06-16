package spacesurvival.controller.gui;

import spacesurvival.controller.gui.command.SwitchGUI;
import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.gui.game.EngineGame;
import spacesurvival.model.worldevent.WorldEventListener;
import spacesurvival.model.World;
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
    public void assignAction() {
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setIdButtons(this.engine.getMainAction(), this.engine.getLinks());
    }

    @Override
    public void assignStrings() {
        this.updateHUD();
    }

    @Override
    public void assignRectangle() {
        this.gui.setBounds(this.engine.getRectangle());
    }

    @Override
    public ActionGUI getMainAction() {
        return this.engine.getMainAction();
    }

    @Override
    public GUI getGUI() {
        return this.gui;
    }

    @Override
    public EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public void changeVisibility() {
        this.switchGUI.changeVisibility();
    }

    @Override
    public void closeGUI() {
        this.gui.close();
    }

    public void updateHUD() {
        this.gui.setTimer(this.engine.getTimer());
        this.gui.setScore(this.engine.getScore());
        this.gui.setRound(this.engine.getRound());
        this.gui.setNEnemies(this.engine.getCountEnemies());
        this.gui.setNHeart(this.engine.getLives());
        this.gui.setLifeShip(this.engine.getLifeShip());
        this.gui.setLifeBoss(this.engine.getLifeBoss());
    }
    
    public void updateRoundState() {
		if (this.engine.getCountEnemies() == 0) {
			System.out.println("finiti nemici, incremento round");
			this.engine.incrRound();
			this.resetEntities();
		}
	}
    
    public void resetEntities() {
		this.getWorld().removeAllEnemies();
		this.getWorld().addAsteroid();
		this.getWorld().addAsteroid();
		this.getWorld().addChaseEnemy();
		this.getWorld().addFireEnemy();
		System.out.println(this.getWorld().getAllEntities());
	}

    public void assignWorld() {
        this.gui.setWorld(this.engine.getWorld());
    }


    public void startTimer() {
        this.engine.startTimer();
    }

    public void stopTimer() {
        this.engine.stopTimer();
    }

    public World getWorld() {
		return this.engine.getWorld();
	}

    public SpaceShipSingleton getShip() {
        return this.engine.getShip();
    }

    public void setEventListenerInWorld(final WorldEventListener worldEventListener) {
        this.engine.setEventListenerInWorld(worldEventListener);
    }

    private MovementKeyListener getMovementKeyListener(){
        return new MovementKeyListener(this.engine.getShip());
    }

    public void assignMovementListenerInShip(){
        this.addKeyListenerShip(this.getMovementKeyListener());
    }

    public boolean isGameOver(){
        return this.engine.isGameOver();
    }

    public void restartGame(){
        this.engine.restartGame();
    }

    public void decreaseLife(final int damage) {
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
    
    public void increaseLife(final int healAmount) {
        this.getShip().increaseLife(healAmount);
    }
    
    public void increaseLives(final int amount) {
        this.engine.increaseLives(amount);
    }

    private boolean damageOverFlow(final int damage) {
        return this.engine.getLifeShip() - damage < 0;
    }

    private boolean hasLivesShip() {
        return this.engine.getLives() > 1;
    }

    public void startPaint() {
        this.gui.startPaint();
    }

    public void repaintWorld() {
        this.gui.repaintGameObjects();
    }

    public void stopPaint(){
        this.gui.stopPaint();
    }

    public void incrScore(final long score) {
        this.engine.incrScore(score);
    }


    public void updateStateWorld(final int elapsed) {
        this.engine.updateStateWorld(elapsed);
    }

    private void addKeyListenerShip(final KeyListener keyListener) {
        this.gui.addKeyListenerSpaceShip(keyListener);
    }

}
