package model.game;

import controller.GUI.CtrlGUI;
import model.GUI.game.EngineGame;
import model.common.P2d;
import model.gameObject.GameObjectUtils;
import model.gameObject.mainGameObject.SpaceShipSingleton;
import model.world.World;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import utilities.DesignSpace;
import utilities.dimension.Screen;

import java.awt.geom.Point2D;
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
    	Point2D UL_screen = EngineGame.DIMENSION.getLocation();
    	
    	P2d UL_P2d = new P2d(UL_screen.getX(), UL_screen.getY());
    	P2d BR_P2d = new P2d(UL_screen.getX() + EngineGame.DIMENSION.getWidth(), UL_screen.getY() + EngineGame.DIMENSION.getHeight());
        this.world = new World(new RectBoundingBox(UL_P2d, BR_P2d));
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
		this.getSpaceship().setPosition(Screen.POINT_CENTER_FULLSCREEN);
	}

	public void setSkin(final String path){
    	this.world.setSkin(path);
	}
}
