package spacesurvival.model.gui.loading;

import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.utilities.dimension.Screen;
import java.awt.Rectangle;
import java.util.List;

public class EngineLoading implements EngineGUI {
    /**
     * Rectangle representing the full screen.
     */
    public static final Rectangle RECTANGLE = Screen.RECTANGLE_FULLSCREEN;
    private final ActionGUI id;

    private int loading;
    private boolean load;

    private Visibility visibility;

    public EngineLoading() {
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
    public void setVisibility(final Visibility state) {
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

    /**
     * Increment the loading bar.
     */
    public void incrLoading() {
        this.loading++;
    }

    /**
     * Get the loading progress.
     * 
     * @return an int representing the loading progress
     */
    public int getLoading() {
        return this.loading;
    }

    /**
     * Set the load true.
     */
    public void load() {
        this.load = true;
    }

    /**
     * Return the loading state.
     * 
     * @return true if is loaded
     */
    public boolean isLoad() {
        return this.load;
    }
}
