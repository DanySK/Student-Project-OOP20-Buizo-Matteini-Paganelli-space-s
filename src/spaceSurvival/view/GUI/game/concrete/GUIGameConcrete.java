package spaceSurvival.view.GUI.game.concrete;

import spaceSurvival.utilities.IdGUI;
import spaceSurvival.view.GUI.AbstractGUI;
import spaceSurvival.view.GUI.game.GUIGame;
import spaceSurvival.view.GUI.game.utilities.*;
import spaceSurvival.view.utilities.ButtonID;

import java.awt.*;
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

    private final PanelGame panelGame;

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
        this.panelGame = new PanelGame();

        this.panelGame.setBounds(super.getBounds());
    }

    @Override
    public List<ButtonID> getButtonLinks() {
        return List.of(this.btnPause);
    }


    @Override
    public void setTimer(final String timer) {
        this.roundTimer.setTimer(timer);
    }

    @Override
    public void setIdButtons(final List<IdGUI> linksID) {
        this.btnPause.setIdGUICurrent(super.getId());
        this.btnPause.setIdGUINext(linksID.get(0));
    }

    @Override
    public PanelGame getPanelGame() {
        return this.panelGame;
    }

    @Override
    public void addKeyListenerSpaceShip(KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }


    @Override
    public void setFontGUI(Font font) {
        this.score.setFont(font);
        this.roundTimer.setFontAll(font);
        this.counterEnemies.setFont(font);
        this.heartLife.setFontAll(font);
    }

    @Override
    public void setFontLifeBars(Font font) {
        this.lifeShip.setFont(font);
        this.lifeBoss.setFont(font);
    }

    @Override
    public void setForegroundGUI(Color color) {
        this.score.setForeground(color);
        this.roundTimer.setForegroundAll(color);
        this.counterEnemies.setForeground(color);
        this.heartLife.setForegroundAll(color);
        this.lifeShip.setForeground(color);
        this.lifeBoss.setForeground(color);
    }

    @Override
    public void setBackgroundLifeBars(Color color) {
        this.lifeShip.setBackground(color);
        this.lifeBoss.setBackground(color);
    }


    @Override
    public void repaintGameObjects(){
        this.panelGame.repaint();
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


}
