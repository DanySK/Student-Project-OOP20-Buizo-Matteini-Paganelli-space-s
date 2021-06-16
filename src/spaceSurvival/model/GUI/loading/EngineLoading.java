package spacesurvival.model.gui.loading;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.utilities.dimension.Screen;

import java.awt.*;
import java.util.List;

public class EngineLoading implements EngineGUI {
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_FULLSCREEN;
    private final ActionGUI id;

    private int loading;
    private boolean load;

    private Visibility visibility;

    public EngineLoading(){
        this.id = ActionGUI.ID_LOADING;
        this.loading = 0;
        this.load = false;
        this.visibility = Visibility.HIDDEN;
    }

    @Override
    public ActionGUI getMainAction() {
        return this.id;
    }

    @Override
    public Rectangle getRectangle() {
        return null;
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
        return List.of();
    }

    public void incrLoading(){
        this.loading++;
    }

    public int getLoading(){
        return this.loading;
    }

    public void load(){
        this.load = true;
    }

    public boolean isLoad(){
        return this.load;
    }
}
