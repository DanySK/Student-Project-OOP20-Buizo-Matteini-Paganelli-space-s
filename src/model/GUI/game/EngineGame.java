package model.GUI.game;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import model.spaceShip.SpaceShipSingleton;
import utilities.IdGUI;

import java.util.List;

public class EngineGame implements EngineGUI {
    private final IdGUI id = IdGUI.ID_GAME;
    private final SpaceShipSingleton spaceShipSingleton;

    private Visibility visibility = Visibility.HIDDEN;

    public EngineGame(){
        this.spaceShipSingleton = SpaceShipSingleton.getSpaceShip();
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
        return null;
    }

    public SpaceShipSingleton getSpaceShipSingleton() {
        return spaceShipSingleton;
    }
}
