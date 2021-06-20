package spacesurvival.controller.gui;

import spacesurvival.controller.gui.command.SwitchGUI;
import spacesurvival.model.gui.EngineGUI;
import spacesurvival.model.gui.Visibility;
import spacesurvival.model.gui.game.EngineGame;
import spacesurvival.model.worldevent.WorldEventListener;
import spacesurvival.model.Pair;
import spacesurvival.model.World;
import spacesurvival.model.commandship.MovementKeyListener;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.ActionGUI;
import spacesurvival.utilities.CommandKey;
import spacesurvival.utilities.CommandType;
import spacesurvival.utilities.RoundUtils;
import spacesurvival.utilities.gameobject.LifeUtils;
import spacesurvival.view.GUI;
import spacesurvival.view.game.GUIGame;

import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

public class CtrlGame implements ControllerGUI {
    private final EngineGame engine;
    private final GUIGame gui;
    private final SwitchGUI switchGUI;
    private final MovementKeyListener keyListener;

    public CtrlGame(final EngineGame engine, final GUIGame gui) {
        this.engine = engine;
        this.gui = gui;
        this.switchGUI = new SwitchGUI(this.engine, this.gui);
        this.keyListener = new MovementKeyListener();

        this.assignAction();
        this.assignStrings();
        this.assignRectangle();
        this.switchGUI.turn(this.engine.getVisibility());
    }

    @Override
    public void assignAction() {
        this.gui.setMainAction(this.engine.getMainAction());
        this.gui.setIdButtons(this.engine.getMainAction(), this.engine.getLinks());
    }

    @Override
    public final void assignStrings() {
        this.updateHUD();
        this.gui.setMaxLifeBoss(LifeUtils.BOSS_LIFE);
        this.gui.setMaxLifeShip(LifeUtils.SPACESHIP_LIFE);
    }

    @Override
    public final void assignRectangle() {
        this.gui.setBoundsGame(this.engine.getRectangle());
    }

    @Override
    public final ActionGUI getMainAction() {
        return this.engine.getMainAction();
    }

    @Override
    public final GUI getGUI() {
        return this.gui;
    }

    @Override
    public final EngineGUI getEngine() {
        return this.engine;
    }

    @Override
    public final boolean isVisibility() {
        return this.engine.isVisible();
    }

    @Override
    public final void turn(final Visibility visibility) {
        this.switchGUI.turn(visibility);
    }

    @Override
    public final void changeVisibility() {
        this.switchGUI.changeVisibility();
    }

    @Override
    public final void closeGUI() {
        this.gui.close();
    }

    public final void updateHUD() {
        this.gui.setTimer(this.engine.getTimer());
        this.gui.setScore(this.engine.getScore());
        this.gui.setRound(this.engine.getRound());
        this.gui.setNEnemies(this.engine.getCountEnemies());
        this.gui.setNHeart(this.engine.getLives());
        this.gui.setLifeShip(this.engine.getLifeShip());
        //this.gui.setBulletHUD(this.engine.getShip().getWeapon().getAmmoType());
        if (this.getWorld().getBoss().isPresent()) {
            this.gui.setLifeBoss(this.engine.getLifeBoss());
        } else {
            this.setVisibleLifeBarBoss(false);
        }
    }

    public void updateRoundState() {
        if (this.engine.getCountEnemies() == 0) {
            this.engine.incrRound();
            this.createNewEntities();
            this.engine.getWorld().getBoss().ifPresent(boss -> this.setVisibleLifeBarBoss(true));
        }
    }

    public void setVisibleLifeBarBoss(final boolean visible) {
        this.gui.setVisibleLifeBarBoss(visible);
    }

    public final void createNewEntities() {
        int asteroidsNumber = this.engine.getRound() * RoundUtils.ASTEROID_INCREMENT_PER_ROUND;
        if (asteroidsNumber > RoundUtils.MAX_ASTEROID_PER_ROUND) {
            asteroidsNumber = RoundUtils.MAX_ASTEROID_PER_ROUND;
        }
        for (int i = 0; i < asteroidsNumber; i++) {
            this.getWorld().addAsteroid();
        }

        int chaseEnemiesNumber = this.engine.getRound() * RoundUtils.CHASE_ENEMY_INCREMENT_PER_ROUND;
        if (chaseEnemiesNumber > RoundUtils.MAX_CHASE_ENEMY_PER_ROUND) {
            chaseEnemiesNumber = RoundUtils.MAX_CHASE_ENEMY_PER_ROUND;
        }
        for (int i = 0; i < chaseEnemiesNumber; i++) {
            this.getWorld().addChaseEnemy();
        }

        if (this.engine.getRound() > RoundUtils.FIRE_ENEMY_MINIMUM_ROUND) {
            int fireEnemiesNumber = this.engine.getRound() * RoundUtils.FIRE_ENEMY_INCREMENT_PER_ROUND
                    - RoundUtils.FIRE_ENEMY_MINIMUM_ROUND;
            if (fireEnemiesNumber > RoundUtils.MAX_FIRE_ENEMY_PER_ROUND) {
                fireEnemiesNumber = RoundUtils.MAX_FIRE_ENEMY_PER_ROUND;
            }
            for (int i = 0; i < fireEnemiesNumber; i++) {
                this.getWorld().addFireEnemy();
            }
        }

        if (this.engine.getRound() % RoundUtils.ROUND_PER_BOSS == 0) {
            this.getWorld().addBoss();
        }
    }

    public final void assignWorld() {
        this.gui.setWorld(this.engine.getWorld());
        this.engine.getWorld().getBoss().ifPresent(boss -> this.setVisibleLifeBarBoss(true));
    }


    public final void startTimer() {
        this.engine.startTimer();
    }

    public final void stopTimer() {
        this.engine.stopTimer();
    }

    public final World getWorld() {
        return this.engine.getWorld();
    }

    public final SpaceShipSingleton getShip() {
        return this.engine.getShip();
    }

    public final void setEventListenerInWorld(final WorldEventListener worldEventListener) {
        this.engine.setEventListenerInWorld(worldEventListener);
    }

    private MovementKeyListener getMovementKeyListener() {
        return this.keyListener;
    }

    /**
     * Return the command list of the ship composed by the input key code and the command type.
     * 
     * @return the command list of the ship
     */
    public List<Pair<CommandKey, CommandType>> getSpaceShipCommandList() {
        return this.keyListener.getSpaceShipCommandList();
    }

    public void clearSpaceShipCommandList() {
        this.keyListener.clearSpaceShipCommandList();
    }

    public final void assignMovementListenerInShip() {
        this.addKeyListenerShip(this.getMovementKeyListener());
    }

    public final boolean isGameOver() {
        return this.engine.isGameOver();
    }

    public final void restartGame() {
        this.engine.restartGame();
    }

    public final void decreaseLife(final int damage) {
        //final int effectDamage = this.damageOverFlow(damage) ? this.engine.getLifeShip() : damage;
        //30 VITA  e  40 DANNO
        System.out.println("VITA " + getShip().getLife());
        System.out.println("DANNO " + damage);
        if (this.damageOverFlow(damage) && this.hasLivesShip()) {
            System.out.println("RESETTO E DECREMENTO");
            this.engine.resetLifeShip();
            this.engine.decreaseLives();
            System.out.println("VITA RESETTATA" + getShip().getLife());
            System.out.println("VITE RIMASTE" + this.engine.getLives());

        } else {
            this.engine.decreaseLifeShip(damage);
//            if (this.hasLivesShip() && this.engine.getLifeShip() == 0) {
//                this.engine.resetLifeShip();
//                this.engine.decreaseLives();
//            }
        }
    }

    public final void increaseLife(final int healAmount) {
        final int totalLife = this.getShip().getLife() + healAmount;
        int newLife = totalLife % LifeUtils.SPACESHIP_LIFE;
        int newLives = totalLife / LifeUtils.SPACESHIP_LIFE;
        if (newLife == 0) {
            newLife = LifeUtils.SPACESHIP_LIFE;
            newLives--;
        }
        this.getShip().setLife(newLife);
        increaseLives(newLives);
    }

    public final void increaseLives(final int amount) {
        this.engine.increaseLives(amount);
    }

    private boolean damageOverFlow(final int damage) {
        return this.engine.getLifeShip() - damage <= 0;
    }

    private boolean hasLivesShip() {
        return this.engine.getLives() > 0;
    }

    public final void repaintWorld() {
        this.gui.repaintGameObjects();
    }

    public final void incrScore(final long score) {
        this.engine.incrScore(score);
    }

    public void updateStateWorld() {
        this.engine.updateStateWorld();
    }

    private void addKeyListenerShip(final KeyListener keyListener) {
        this.gui.addKeyListenerSpaceShip(keyListener);
    }

}
