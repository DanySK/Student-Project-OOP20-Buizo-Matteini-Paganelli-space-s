package spacesurvival.view.game.concrete;

import spacesurvival.model.World;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.game.GUIGame;
import spacesurvival.view.game.utilities.*;
import spacesurvival.view.game.utilities.logicColor.LogicColorBoss;
import spacesurvival.view.game.utilities.logicColor.LogicColorShip;
import spacesurvival.view.utilities.BtnAction;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.util.List;

public class GUIGameConcrete extends AbstractGUI implements GUIGame {
    private static final long serialVersionUID = 1588822389694751549L;
    
    private final Score score;
    private final RoundTimer roundTimer;
    private final BtnPauseID btnPause;
    private final CounterEnemies counterEnemies;

    private final Heart heartLife;
    private final LifeBar lifeShip;
    private final LifeBar lifeBoss;
    private final Bullet bullet;

    private final PanelEntityGame entityGame;
    private final PanelBulletGame bulletGame;

    public GUIGameConcrete() {
        super();
        this.entityGame = new PanelEntityGame();
        this.bulletGame = new PanelBulletGame();
        this.lifeBoss = new LifeBar(new LogicColorBoss());
        this.lifeShip = new LifeBar(new LogicColorShip());
        this.score = new Score();
        this.heartLife = new Heart();
        this.bullet = new Bullet();
        this.roundTimer = new RoundTimer();
        this.btnPause = new BtnPauseID();
        this.counterEnemies = new CounterEnemies();
    }

    public final void setBoundsGame(final Rectangle screen) {
        super.setBounds(screen);
        this.entityGame.setBounds(screen);
        this.bulletGame.setBounds(screen);
    }

    @Override
    public final List<BtnAction> getBtnActionLinks() {
        return List.of(this.btnPause);
    }


    @Override
    public final void setTimer(final String timer) {
        this.roundTimer.setTimer(timer);
    }

    @Override
    public final void setIdButtons(final ActionGUI mainAction, final List<ActionGUI> linksID) {
        for (final ActionGUI actionGUI : linksID) {
            this.btnPause.setActionCurrent(mainAction);
            this.btnPause.setActionNext(actionGUI);
        }
    }

    @Override
    public final PanelEntityGame getPanelEntity() {
        return this.entityGame;
    }

    @Override
    public PanelBulletGame getPanelBullet() {
        return this.bulletGame;
    }

    @Override
    public final void setWorld(final World world) {
        this.entityGame.setWorld(world);
        this.bulletGame.setWorld(world);
    }

    @Override
    public final void addKeyListenerSpaceShip(final KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }

    @Override
    public final void repaintGameObjects(){
        this.entityGame.repaint();
        this.bulletGame.repaint();
    }

    @Override
    public final void setScore(final long score) {
        this.score.setScore(score);
    }

    @Override
    public final void setRound(final int round) {
        this.roundTimer.setRound(round);
    }

    @Override
    public final void setNEnemies(final long count) {
        this.counterEnemies.setCounter(count);
    }

    @Override
    public final void setNHeart(final int nHeart) {
        this.heartLife.setnHeart(nHeart);
    }

    @Override
    public final void setLifeShip(final int lifeShip) {
        this.lifeShip.setLife(lifeShip);
    }

    @Override
    public final void setLifeBoss(final int lifeShip) {
        this.lifeBoss.setLife(lifeShip);
    }


    @Override
    public void setFontGUI(final Font font) {
        this.score.setFontAll(font);
        this.roundTimer.setFontAll(font);
        this.counterEnemies.setFontAll(font);
        this.heartLife.setFontAll(font);
    }

    @Override
    public void setFontLifeBars(final Font font) {
        this.lifeShip.setFont(font);
        this.lifeBoss.setFont(font);
    }

    @Override
    public void setForegroundGUI(final Color color) {
        this.score.setForegroundAll(color);
        this.roundTimer.setForegroundAll(color);
        this.counterEnemies.setForegroundAll(color);
        this.heartLife.setForegroundAll(color);
        this.lifeShip.setForeground(color);
        this.lifeBoss.setForeground(color);
    }

    @Override
    public void setBackgroundLifeBars(final Color color) {
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
