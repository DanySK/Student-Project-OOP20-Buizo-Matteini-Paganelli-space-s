package spacesurvival.view.game.concrete;

import spacesurvival.model.World;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.game.GUIGame;
import spacesurvival.view.game.utilities.*;
import spacesurvival.view.game.utilities.logicColor.LogicColorBoss;
import spacesurvival.view.game.utilities.logicColor.LogicColorShip;
import spacesurvival.view.utilities.BtnAction;

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
        this.lifeBoss = new LifeBar(new LogicColorBoss());
        this.lifeShip = new LifeBar(new LogicColorShip());
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
    public List<BtnAction> getBtnActionLinks() {
        return List.of(this.btnPause);
    }


    @Override
    public void setTimer(final String timer) {
        this.roundTimer.setTimer(timer);
    }

    @Override
    public void setIdButtons(final ActionGUI mainAction, final List<ActionGUI> linksID) {
        for(int i = 0; i< linksID.size(); i++){
            this.btnPause.setActionCurrent(mainAction);
            this.btnPause.setActionNext(linksID.get(i));
        }
    }

    @Override
    public PanelGame getPanelGame() {
        return this.panelGame;
    }


    @Override
    public void startPaint() {
        this.panelGame.startPaint();
    }

    @Override
    public void stopPaint() {
        this.panelGame.stopPaint();
    }

    @Override
    public void setWorld(final World world) {
        this.panelGame.setWorld(world);
    }

    @Override
    public void addKeyListenerSpaceShip(KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }

    @Override
    public void repaintGameObjects(){
        this.panelGame.repaint();
    }

    @Override
    public void setScore(final long score) {
        this.score.setScore(score);
    }

    @Override
    public void setRound(final int round) {
        this.roundTimer.setRound(round);
    }

    @Override
    public void setNEnemies(final long count) {
        this.counterEnemies.setCounter(count);
    }

    @Override
    public void setNHeart(final int nHeart) {
        this.heartLife.setnHeart(nHeart);
    }

    @Override
    public void setLifeShip(final int lifeShip) {
        this.lifeShip.setLife(lifeShip);
    }

    @Override
    public void setLifeBoss(int lifeShip) {
        this.lifeBoss.setLife(lifeShip);
    }


    @Override
    public void setFontGUI(Font font) {
        this.score.setFontAll(font);
        this.roundTimer.setFontAll(font);
        this.counterEnemies.setFontAll(font);
        this.heartLife.setFontAll(font);
    }

    @Override
    public void setFontLifeBars(Font font) {
        this.lifeShip.setFont(font);
        this.lifeBoss.setFont(font);
    }

    @Override
    public void setForegroundGUI(Color color) {
        this.score.setForegroundAll(color);
        this.roundTimer.setForegroundAll(color);
        this.counterEnemies.setForegroundAll(color);
        this.heartLife.setForegroundAll(color);
        this.lifeShip.setForeground(color);
        this.lifeBoss.setForeground(color);
    }

    @Override
    public void setBackgroundLifeBars(Color color) {
        this.lifeShip.setBackground(color);
        this.lifeBoss.setBackground(color);
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