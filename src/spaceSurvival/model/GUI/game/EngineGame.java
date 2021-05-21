package spaceSurvival.model.GUI.game;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.model.gameObject.GameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.model.worldEcollisioni.WorldEventListener;
import spaceSurvival.utilities.IdGUI;
import spaceSurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class EngineGame implements EngineGUI {
    public static final Rectangle DIMENSION = Screen.RECTANGLE_FULLSCREEN;
    public static final int N_BUTTONS = 6;

    private final IdGUI id;
    private final IdGUI idPause;

    private final World world;
    private final EngineHUD hud;

	private Visibility visibility;

    public EngineGame(){
        this.id = IdGUI.ID_GAME;
        this.idPause = IdGUI.ID_PAUSE;
        this.world = new World(DIMENSION);
        this.hud = new EngineHUD();
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public IdGUI getId() {
        return this.id;
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
    public List<IdGUI> getLinks() {
        return List.of(this.idPause);
    }


    public boolean isStartTimer(){
        return this.hud.isStartTimer();
    }

    public String getTimer(){
        return this.hud.getTimer();
    }

    public void initTimer(){
        this.hud.initTimer();
    }

    public void startTimer(){
        this.hud.startTimer();
    }

    public long getScore(){
        return this.hud.getScore();
    }

    public int getRound(){
        return this.hud.getRound();
    }

    public long getCountEnemies(){
        return this.world.getCountEnemies();
    }

    public int getHeartShip(){
        return this.hud.getHeartShip();
    }

    public int getLifeShip(){
        return this.world.getLifeShip();
    }

    public int getLifeBoss(){
        return this.world.getLifeBoss();
    }

    public void incrScore(final long score){
        this.hud.incrScore(score);
    }

    public void incrRound(){
        this.hud.incrRound();
    }

    public void decrLifeShip(final int damage){
        this.world.getShip().decreaseLife(damage);
    }

    public void decrHeartShip(){
        this.hud.decrHeartShip();
    }

    public boolean isGameOver(){
        return this.hud.isGameOver();
    }

    public World getWorld(){
        return this.world;
    }

    public Set<GameObject> getAllGameObject(){
        return this.world.getAllEntities();
    }

    public SpaceShipSingleton getShip(){
        return this.world.getShip();
    }

    public void setEventListenerInWorld(final WorldEventListener worldEventListener){
        this.world.setEventListener(worldEventListener);
    }

    public void updateStateWorld(final int elapsed){
        this.world.updateState(elapsed);
    }

    public void moveShip(){
        this.world.moveShip();
    }
}
