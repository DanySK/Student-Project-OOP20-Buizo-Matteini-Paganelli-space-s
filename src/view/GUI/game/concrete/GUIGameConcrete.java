package view.GUI.game.concrete;

import utilities.IdGUI;
import view.GUI.AbstractGUI;
import view.GUI.game.GUIGame;
import view.GUI.game.utilities.*;
import view.utilities.ButtonID;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.util.List;

public class GUIGameConcrete extends AbstractGUI implements GUIGame {
    private final Score score;
    private final RoundTimer roundTimer;
    private final BtnPauseID btnPause;
    private final CounterEnemies counterEnemies;

    private final Heart heartLife;
    private final LifeBar lifeShip;
    private final LifeBar lifeBoss;
    private final Bullet bullet;

    private PanelGame panelGame = new PanelGame();

    public GUIGameConcrete(){
        super();
        this.lifeBoss = new LifeBar();
        this.lifeShip = new LifeBar();
        this.score = new Score();
        this.heartLife = new Heart();
        this.bullet = new Bullet();
        this.roundTimer = new RoundTimer();
        this.btnPause = new BtnPauseID();
        this.counterEnemies = new CounterEnemies();

        panelGame.setBounds(super.getBounds());
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return List.of(this.btnPause);
    }

    public LifeBar getLifeBoss() {
        return this.lifeBoss;
    }

    public LifeBar getLifeShip(){
        return this.lifeShip;
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


    @Override
    public void setTimer(String timer) {
        this.roundTimer.setTimer(timer);
    }

    @Override
    public void setIdButtons(List<IdGUI> linksID) {
        this.btnPause.setIdGUICurrent(super.getId());
        this.btnPause.setIdGUINext(linksID.get(0));
    }

    @Override
    public PanelGame getPanelGame() {
        return this.panelGame;
    }

    @Override
    public void addKeyListenerSpaceship(KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }

    @Override
    public void repaintGameObjects(){
        this.panelGame.repaint();
    }

}
