package spaceSurvival.model.GUI.game;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.World;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.utilities.ActionGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
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

    public EngineGame(){
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
    public void setVisibility(Visibility state) {
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

    public void stopTimer(){
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

    public boolean hasLostLife() {
        return this.world.getLifeShip() == 0;
    }

    public void setLifeShip(final int life) {
        this.world.getShip().setLife(life);
    }

    public void resetLifeShip() {
        this.world.getShip().increaseLife(100);
    }

    public boolean isGameOver() {
        return this.hud.isGameOver() && this.hasLostLife();
    }

    public World getWorld() {
        return this.world;
    }

    public void restartGame(){
        this.resetLifeShip();
        this.hud.resetLives();
        this.hud.resetTimer();
    }

    public Set<GameObject> getAllEntities() {
        return this.world.getAllEntities();
    }

    public SpaceShipSingleton getShip() {
        return this.world.getShip();
    }

    public void setEventListenerInWorld(final WorldEventListener worldEventListener) {
        this.world.setEventListener(worldEventListener);
    }

    public void updateStateWorld(final int elapsed) {
        this.world.updateState(elapsed);
    }

    public void moveShip() {
        this.world.moveShip();
    }

}
