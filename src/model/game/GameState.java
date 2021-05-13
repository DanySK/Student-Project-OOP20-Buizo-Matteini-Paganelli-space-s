package model.game;

import controller.GUI.CtrlGUI;
import model.gameObject.AbstractGameObject;
import model.gameObject.MovableGameObject;
import model.gameObject.spaceShip.SpaceShipSingleton;
import model.world.World;
import model.worldEcollisioni.physics.boundingType.RectBoundingBox;

import java.util.Timer;

public class GameState {
    private Timer timer;
    private int score;
    private int round;
    private World world;
    private CtrlGUI controllerGUI;

	private int lives;
    private int life;


    public GameState(){
        this.world = new World(new RectBoundingBox(null, null));
    }

    public World getWorld(){
        return this.world;
    }

    public SpaceShipSingleton getSpaceship(){
        return this.world.getShip();
    }

    public boolean isGameOver(){
        return false;
    }
    
    public int getLives() {
		return lives;
	}
    
	public void increaseLives(){
		this.lives++;
	}

	public void decreaseLives(){
		this.lives--;
	}
	
	public void resetLives(){
		this.lives = 5;
	}
	
    public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
}
