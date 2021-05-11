package model.game;

import controller.GUI.CtrlGUI;
import model.gameObject.AbstractGameObject;
import model.world.World;
import model.worldEcollisioni.RectBoundingBox;
import view.GUI.game.GUIGame;

import java.util.Timer;

public class GameState {
    private Timer timer;
    private int score;
    private int round;
    private World world;
    private CtrlGUI controllerGUI;

    public GameState(){
        this.world = new World(new RectBoundingBox(null, null));
    }

    public World getWorld(){
        return this.world;
    }

    public AbstractGameObject getSpaceship(){
        return this.world.getShip();
    }

    public boolean isGameOver(){
        return false;
    }
}
