package model.GUI.game;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.gameObject.spaceShip.SpaceShipSingleton;
import model.input.MovementKeyListener;
import utilities.IdGUI;
import utilities.dimension.Screen;

import java.awt.*;
import java.util.List;

public class EngineGame implements EngineGUI {
    public static final Rectangle DIMENSION = Screen.RECTANGLE_FULLSCREEN;

    public static final int N_BUTTONS = 6;
    private final IdGUI id = IdGUI.ID_GAME;
    private final IdGUI idPause = IdGUI.ID_PAUSE;


    private final SpaceShipSingleton spaceShipSingleton;
    private final MovementKeyListener movementKeyListener;

	private Visibility visibility = Visibility.HIDDEN;

    public EngineGame(){
        this.spaceShipSingleton = SpaceShipSingleton.getSpaceShip();
        this.movementKeyListener = new MovementKeyListener(this.spaceShipSingleton);
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
    
    public MovementKeyListener getMovementKeyListener() {
		return this.movementKeyListener;
	}
}
