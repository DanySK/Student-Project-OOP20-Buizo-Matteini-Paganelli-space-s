package model.GUI.game;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.IdGUI;

import java.util.List;

public class EngineGame implements EngineGUI {
    private final IdGUI id = IdGUI.ID_GAME;

    private Visibility visibility = Visibility.HIDDEN;

    public EngineGame(){

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
}
