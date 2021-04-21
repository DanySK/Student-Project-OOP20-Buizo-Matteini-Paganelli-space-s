package view.GUI.game.concrete;

import utilities.IconPath;
import view.GUI.AbstractGUI;
import view.GUI.game.GUIGame;
import view.GUI.game.utilities.*;
import view.utilities.ButtonID;
import view.utilities.JImageRate;

import javax.swing.*;
import java.util.List;

public class GUIGameConcrete extends AbstractGUI implements GUIGame {
    private final Score score;
    private final RoundTimer roundTimer;
    private final BtnPauseID btnPause;
    private final CounterEnemies counterEnemies;

    private final Heart heartLife;
    private final LifeBar life;
    private final Bullet bullet;

    public GUIGameConcrete(){
        super();
        this.life = new LifeBar();
        this.score = new Score();
        this.heartLife = new Heart();
        this.bullet = new Bullet();
        this.roundTimer = new RoundTimer();
        this.btnPause = new BtnPauseID();
        this.counterEnemies = new CounterEnemies();
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return List.of(this.btnPause);
    }

    public JProgressBar getLife() {
        return this.life;
    }

    public Score getScore() {
        return this.score;
    }

    public Heart getHeartLife() {
        return this.heartLife;
    }

    public Bullet getBullet() {
        return this.bullet;
    }

    public RoundTimer getRoundTimer() {
        return this.roundTimer;
    }

    public CounterEnemies getCounterEnemies() {
        return this.counterEnemies;
    }

    public BtnPauseID getBtnPause() {
        return btnPause;
    }
}
