package model.game;

import controller.GUI.CtrlGUI;
import model.gameObject.GameObjectUtils;
import model.gameObject.spaceShip.SpaceShipSingleton;
import model.world.World;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import utilities.DesignSpace;

import java.util.Timer;

public class GameState {
    private Timer timer;
    private int score;
    private int round;
    private World world;
    private CtrlGUI controllerGUI;
    
    private boolean gameOver = false;

	private int lives;

    public GameState(){
        this.world = new World(new RectBoundingBox(null, null));
    }

    public World getWorld(){
        return this.world;
    }

    public SpaceShipSingleton getSpaceship(){
        return this.world.getShip();
    }

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
    public boolean isGameOver(){
        return this.gameOver;
    }
    
    public int getLives() {
		return lives;
	}
    
	public void increaseLives(){
		this.lives++;
	}

	public void decreaseLives(){
		this.lives--;
		if (getLives() == 0) {
			this.setGameOver(true);
		} else {
			this.respawn();
		}
	}
	
	public void resetLives(){
		this.lives = 5;
	}
	
    public int getLife() {
    	return this.getSpaceship().getLife();
	}

    public void increaseLife(int heal) {
    	this.getSpaceship().increaseLife(heal);
	}
    
	public void decreaseLife(int damage) {
    	this.getSpaceship().decreaseLife(damage);
    	if (this.getLife() == 0) {
			this.increaseLife(GameObjectUtils.SPACESHIP_LIFE);
			this.decreaseLives();
		}
	}
	
	public void respawn() {
		this.getSpaceship().setPosition(DesignSpace.CENTER_ENVIRONMENT);
	}
}
