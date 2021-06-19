package spacesurvival.model;

import spacesurvival.controller.gui.CtrlGUI;
import spacesurvival.controller.gui.CtrlGame;
import spacesurvival.controller.gui.CtrlSound;
import spacesurvival.model.collision.event.DeadEvent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.movable.MovableObject;
import spacesurvival.model.sound.CmdAudioType;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.model.worldevent.WorldEventListener;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.utilities.ThreadUtils;
import java.awt.geom.AffineTransform;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class EngineLoop extends Thread implements WorldEventListener {
    /**
     * Frames per second of the game.
     */
    public static final int FPS = 30;

    private final CtrlGUI controlGUI;
    private final CtrlGame controlGame;
    private final CtrlSound controlSound;

    private final List<WorldEvent> eventQueue;

    public EngineLoop() {
        this.controlGUI = new CtrlGUI();
        this.eventQueue = new LinkedList<>();
        this.controlGame = this.controlGUI.getCtrlGame();
        this.controlSound = this.controlGUI.getCtrlSound();
    }

    public void initGame() {
        this.controlGUI.assignSoundLoop();
        this.controlGame.assignMovementListenerInShip();
        this.controlGame.setEventListenerInWorld(this);
        this.controlGame.assignWorld();
        this.controlSound.setSoundLoop(this.controlGUI.getCurrentGUI());
        this.controlSound.setCmdAudioLoop(CmdAudioType.AUDIO_ON);
        this.controlGUI.startGUI();
    }

    public World getWorld() {
        return this.controlGame.getWorld();
    }

    public SpaceShipSingleton getShip() {
        return this.controlGame.getWorld().getShip();
    }

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        long current = 0L;
        final int nbThreadsss = Thread.getAllStackTraces().keySet().size();


        while (true) {
            if (!this.controlGame.isGameOver()) {
                current = System.currentTimeMillis();
                final int elapsed = (int) (current - lastTime);
                int nbThreads = Thread.getAllStackTraces().keySet().size();

                if (this.controlGUI.isInGame()) {
                    if (!this.controlGUI.isInPause()) {
                        //processInput();
                        renderMovement();
                        render();
                        waitForNextFrame(current);
                        lastTime = current;
                        updateGame();
                        nbThreads = Thread.getAllStackTraces().keySet().size();

                        System.out.println("Numero dei thread current -> " + nbThreads);
                    }
                }

                if (this.controlGUI.isInGame() || !this.controlGUI.isInPause()) {
                    waitForNextFrame(current);
                    lastTime = current;
                }
            } else {
                renderGameOver();

                while (this.controlGUI.isInGameOver()) {
                    waitForNextFrame(current);
                    lastTime = current;
                }

            }

        }
    }

    protected void waitForNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < FPS) {
            ThreadUtils.sleep(FPS - dt);
        }
    }

    protected void processInput() {
//        gameState.getWorld().getShip().updateInput(controller);
    }

    protected final void updateGame() {
        this.controlGame.updateStateWorld();
        this.checkEvents();
        this.checkSoundEffects();
        this.checkGameObjectsDead();
        this.assignTargetToEnemies();
        this.checkScore();
        this.checkLife();
        this.controlGame.updateHUD();
    }

    private void checkGameObjectsDead() {
        final World world = this.getWorld();
        world.getMainObjects().forEach(mainObject -> {
            if (mainObject.isDead()) {
                eventQueue.add(new DeadEvent(mainObject));
                this.controlGame.incrScore(mainObject.getScore());
            }
        });
    }

    protected void checkSoundEffects() {
        getWorld().getSoundQueue().addAll(getShip().getSoundQueue());
        getWorld().getSoundQueue().forEach(this::playEffect);
        getWorld().getSoundQueue().clear();
        getShip().getSoundQueue().clear();
    }

    protected void checkScore() {
        final List<Integer> scoreUpdate = getWorld().getQueueScore();
        scoreUpdate.forEach(this.controlGame::incrScore);
        scoreUpdate.clear();
    }

    protected void checkLife() {
        final List<Integer> listIncreaseLife = getWorld().getQueueIncreaseLife();
        final List<Integer> listDecreaseLife = getWorld().getQueueDecreaseLife();

        listIncreaseLife.forEach(this.controlGame::increaseLife);
        listDecreaseLife.forEach(this.controlGame::decreaseLife);

        listIncreaseLife.clear();
        listDecreaseLife.clear();
    }


    protected void checkEvents() {
        final World world = getWorld();
        eventQueue.forEach(ev -> {
            ev.manage(world);
            this.controlGame.updateRoundState();
        });
        eventQueue.clear();
    }

    protected final void render() {
        this.controlGame.repaintWorld();
    }

    private void renderMovement() {
        getWorld().getMovableObjects().forEach(MovableObject::move);
    }

    public void assignTargetToEnemies() {
        getWorld().getAllEnemies().forEach(enemy -> {
            final AffineTransform trans = new AffineTransform();
            trans.setTransform(getShip().getTransform());
            trans.translate(getShip().getWidth() / 2, getShip().getHeight() / 2);
            final P2d target = new P2d(trans.getTranslateX(), trans.getTranslateY());
            enemy.setTarget(Optional.of(target));

            //enemy.setTarget(Optional.of(this.controlGame.getShip().getPosition()));
        });
    }

    protected void renderGameOver() {
        this.controlGUI.endGame();
        playEffect(SoundPath.GAME_OVER);
    }

    @Override
    public void notifyEvent(final WorldEvent ev) {
        eventQueue.add(ev);
    }

    private void playEffect(final SoundPath soundPath) {
        this.controlSound.getCallerAudioEffectFromSoundPath(soundPath).get().execute(CmdAudioType.RESET_TIMING);
        this.controlSound.getCallerAudioEffectFromSoundPath(soundPath).get().execute(CmdAudioType.AUDIO_ON);
    }

}

