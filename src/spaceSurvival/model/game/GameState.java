package spaceSurvival.model.game;

import spaceSurvival.controller.GUI.CtrlGUI;
import spaceSurvival.model.GUI.game.EngineGame;
import spaceSurvival.model.GUI.game.EngineHUD;
import spaceSurvival.model.common.P2d;
import spaceSurvival.model.gameObject.GameObjectUtils;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.GUI.game.World;
import spaceSurvival.model.worldEcollisioni.physics.boundingType.RectBoundingBox;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Timer;

public class GameState {
	
    private World world;
    private long score;
	private int lives;
    private int round;
    
    private CtrlGUI controllerGUI;
    private Timer timer;

    private boolean gameOver = false;


    public GameState(){
    	Point2D UL_screen = EngineGame.DIMENSION.getLocation();
    	
    	P2d UL_P2d = new P2d(UL_screen.getX(), UL_screen.getY());
    	P2d BR_P2d = new P2d(UL_screen.getX() + EngineGame.DIMENSION.getWidth(), UL_screen.getY() + EngineGame.DIMENSION.getHeight());
        this.world = new World(new RectBoundingBox(UL_P2d, BR_P2d));
        this.score = EngineHUD.INIT_SCORE;
        this.lives = GameObjectUtils.SPACESHIP_LIVES;
        this.round = EngineHUD.INIT_ROUND;
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

	public long getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void increaseScore(int points) {
		this.score += points;
	}
	
	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public void increaseRound() {
		this.round++;
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
	
    public int getLife() {
    	return this.getSpaceship().getLife();
	}

    public void increaseLife(int heal) {
    	this.getSpaceship().increaseLife(heal);
	}
    
	public void decreaseLife(int damage) {
    	this.getSpaceship().decreaseLife(damage);
    	
    	if (this.getLife() <= 0) {
			System.out.println("Ho perso tutta la vita");
			this.decreaseLives();
		}
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
		System.out.println("Decremento vita, vite rimaste: " + this.lives);
		if (getLives() == 0) {
			this.setGameOver(true);
		} else {
			this.getSpaceship().setLife(GameObjectUtils.SPACESHIP_LIFE);
			System.out.println("Ho ancora altre vite, ripristino la vita: " + this.getLife());
			this.respawn();
		}
	}
	
	public void resetLives(){
		this.lives = 5;
	}
	public void respawn() {
		this.getSpaceship().setTransform(new AffineTransform()); 
		this.getSpaceship().setPosition(Screen.POINT_CENTER_FULLSCREEN);
	}

	public void setSkin(final String path){
    	this.world.setSkin(path);
	}
}
