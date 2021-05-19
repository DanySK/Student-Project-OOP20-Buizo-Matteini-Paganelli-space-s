package spaceSurvival.model.GUI.loading;

import spaceSurvival.model.GUI.EngineGUI;
import spaceSurvival.model.GUI.Visibility;
import spaceSurvival.utilities.IdGUI;

import java.util.List;

public class EngineLoading implements EngineGUI {
    private final IdGUI id;

    private int loading;
    private boolean load;

    private Visibility visibility;

    public EngineLoading(){
        this.id = IdGUI.ID_LOADING;
        this.loading = 0;
        this.load = false;
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
