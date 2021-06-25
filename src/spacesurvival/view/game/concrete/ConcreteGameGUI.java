package spacesurvival.view.game.concrete;

import spacesurvival.model.World;
import spacesurvival.model.gameobject.takeable.ammo.AmmoType;
import spacesurvival.utilities.LinkActionGUI;
import spacesurvival.view.AbstractGUI;
import spacesurvival.view.game.GUIGame;
import spacesurvival.view.game.utilities.BtnPauseID;
import spacesurvival.view.game.utilities.Bullet;
import spacesurvival.view.game.utilities.CounterEnemies;
import spacesurvival.view.game.utilities.Heart;
import spacesurvival.view.game.utilities.LifeBar;
import spacesurvival.view.game.utilities.PanelBulletGame;
import spacesurvival.view.game.utilities.PanelEntityGame;
import spacesurvival.view.game.utilities.RoundTimer;
import spacesurvival.view.game.utilities.Score;
import spacesurvival.view.game.utilities.logicColor.LogicColorBoss;
import spacesurvival.view.game.utilities.logicColor.LogicColorShip;
import spacesurvival.view.utilities.ButtonLink;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyListener;
import java.util.List;

public class ConcreteGameGUI extends AbstractGUI implements GUIGame {
    private static final long serialVersionUID = 1588822389694751549L;

    private final Score score;
    private final RoundTimer roundTimer;
    private final BtnPauseID btnPause;
    private final CounterEnemies counterEnemies;

    private final Heart heartLife;
    private final LifeBar lifeShip;
    private final LifeBar lifeBoss;
    private final Bullet bullet;

    private final PanelEntityGame entityPanel;
    private final PanelBulletGame bulletPanel;

    public ConcreteGameGUI() {
        super();
        this.entityPanel = new PanelEntityGame();
        this.bulletPanel = new PanelBulletGame();
        this.lifeBoss = new LifeBar(new LogicColorBoss());
        this.lifeShip = new LifeBar(new LogicColorShip());
        this.score = new Score();
        this.heartLife = new Heart();
        this.bullet = new Bullet();
        this.roundTimer = new RoundTimer();
        this.btnPause = new BtnPauseID();
        this.counterEnemies = new CounterEnemies();
    }

    @Override
    public final void setBoundsGame(final Rectangle screen) {
        super.setBounds(screen);
        this.entityPanel.setBounds(screen);
        this.bulletPanel.setBounds(screen);
    }

    @Override
    public final List<ButtonLink> getBtnActionLinks() {
        return List.of(this.btnPause);
    }


    @Override
    public final void setTimer(final String timer) {
        this.roundTimer.setTimer(timer);
    }

    @Override
    public final void setIdButtons(final LinkActionGUI mainAction, final List<LinkActionGUI> linksID) {
        for (final LinkActionGUI linkActionGUI : linksID) {
            this.btnPause.setCurrentLink(mainAction);
            this.btnPause.setNextLink(linkActionGUI);
        }
    }

    @Override
    public final PanelEntityGame getPanelEntity() {
        return this.entityPanel;
    }

    @Override
    public PanelBulletGame getPanelBullet() {
        return this.bulletPanel;
    }

    @Override
    public final void setWorld(final World world) {
        this.entityPanel.setWorld(world);
        this.bulletPanel.setWorld(world);
    }

    @Override
    public final void addKeyListenerSpaceShip(final KeyListener keyListener) {
        this.addKeyListener(keyListener);
    }

    @Override
    public final void repaintGameObjects() {
        this.entityPanel.repaint();
        //this.bulletPanel.repaint();
    }

    @Override
    public void setVisibleLifeBarBoss(final boolean visible) {
        this.lifeBoss.setVisible(visible); 
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

    @Override
    public void setNamePlayer(final String namePlayer) {
        this.score.setNamePlayer(namePlayer);
    }
    
    public LifeBar getLifeBoss() {
        return this.lifeBoss;
    }

    public LifeBar getLifeShip() {
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
    public void setMaxLifeShip(final int maxLife) {
        this.lifeShip.setMaximum(maxLife);
    }

    @Override
    public void setMaxLifeBoss(final int maxLife) {
        this.lifeBoss.setMaximum(maxLife);
    }

    @Override
    public void setBulletHUD(final AmmoType ammoType) {
        this.bullet.setAmmoTypeImage(ammoType.getImagePath());
        this.bullet.setBulletImage(ammoType.getBulletHud());
    }

    @Override
    public void setFontTitleGUI(final Font font) {
    }

    @Override
    public void setTitleGUI(final String title) {
    }

}
