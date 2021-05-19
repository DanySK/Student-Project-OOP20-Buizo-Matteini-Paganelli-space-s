package spaceSurvival.model.game;

import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.world.World;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.utilities.dimension.Screen;

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
    
    public void setWorld(World world) {
		this.world = world;
	}

    public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public CtrlGUI getControllerGUI() {
		return controllerGUI;
	}

	public void setControllerGUI(CtrlGUI controllerGUI) {
		this.controllerGUI = controllerGUI;
	}

	public SpaceShipSingleton getSpaceship(){
        return this.world.getShip();
    }

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
		System.out.println("GameOver" + gameOver);
	}
	
    public boolean isGameOver(){
        return this.gameOver;
    }
    
    public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}
    
	public void increaseLives(){
		this.lives++;
	}

	public void decreaseLives(){
		this.lives--;
		System.out.println("Decremento vita" + this.lives);
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
