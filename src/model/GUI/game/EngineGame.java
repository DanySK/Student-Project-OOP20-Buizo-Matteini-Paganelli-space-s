package model.GUI.game;

import model.GUI.EngineGUI;
import model.GUI.Visibility;
import utilities.IdGUI;
import utilities.dimension.Screen;

import java.awt.*;
import java.util.List;

public class EngineGame implements EngineGUI {
    public static final Rectangle DIMENSION = Screen.RECTANGLE_FULLSCREEN;

    public static final int INITIAL_SCORE = 0;
    public static final int INITIAL_ROUND = 1;
    public static final int N_BUTTONS = 6;
    private final IdGUI id;
    private final IdGUI idPause;

    private final Chronometer chronometer;

	private Visibility visibility;

    public EngineGame(){
        this.id = IdGUI.ID_GAME;
        this.idPause = IdGUI.ID_PAUSE;
        this.visibility = Visibility.HIDDEN;
        this.chronometer = new Chronometer();
    }

    public boolean isStartTimer(){
        return this.chronometer.isPlay();
    }

    public String getTimer(){
        return this.chronometer.getTimer();
    }

    public void initTimer(){
        this.chronometer.start();
    }

    public void startTimer(){
        this.chronometer.play();
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

}
