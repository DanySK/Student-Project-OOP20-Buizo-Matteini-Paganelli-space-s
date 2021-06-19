package spacesurvival.view.game.utilities;

import spacesurvival.model.World;
import spacesurvival.model.collision.physics.bounding.CircleBoundingBox;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.EngineLoop;
import spacesurvival.model.Pair;
import spacesurvival.model.gameobject.fireable.Boss;
import spacesurvival.model.gameobject.main.MainObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.model.gameobject.takeable.TakeableGameObject;
import spacesurvival.utilities.ThreadUtils;
import spacesurvival.view.game.utilities.commandlife.CallerLife;
import spacesurvival.view.game.utilities.logicColor.LogicColorShip;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.swing.JPanel;

public class PanelEntityGame extends JPanel {

    private static final long serialVersionUID = -6158413043296871948L;

    public static final int ANCHOR_X_LIFE_BAR = 0;
    public static final int HEIGHT_LIFE_BAR = 6;
    public static final int HEIGHT_LIFE = 5;
    public static final int DIFFERENCE_HEIGHT_LIFE_BAR = Math.abs(HEIGHT_LIFE_BAR - HEIGHT_LIFE);
    
    private final Map<GameObject, Pair<Image, Image>> objects;
    private Optional<World> world;

    private final Thread taskObjects;

    public PanelEntityGame() {
        super(); 
        super.setOpaque(false);

        this.taskObjects = new Thread(PanelEntityGame.this::runUpdateGameObjects);
        this.objects = new HashMap<>();
        this.world = Optional.empty();

        this.taskObjects.start();
    }

    public void setWorld(final World world) {
        this.world = Optional.of(world);
    }

    @Override
    public final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

        this.objects.entrySet().forEach(entity -> {
            g2d.setTransform(getCorrectAffineTransformFromBoundingBox(entity.getKey())); 
            g2d.drawImage(entity.getValue().getX(), 0, 0, null);
            g2d.drawImage(entity.getValue().getY(), 0, 0, null);
            this.assignLifeBar(entity.getKey(), g2d);
        });     
    }

    private void drawLifeBar(final Graphics2D g2d, final GameObject gameObject) {
        this.drawBar(g2d, gameObject);
        this.drawLife(g2d, gameObject);
    }

    private void drawBar(final Graphics2D g2d, final GameObject gameObject) {
        g2d.setColor(Color.WHITE);
        g2d.drawRect(ANCHOR_X_LIFE_BAR, (int) gameObject.getSize().getHeight(), (int) gameObject.getSize().getWidth(), HEIGHT_LIFE_BAR);
    }

    private void drawLife(final Graphics2D g2d, final GameObject gameObject){
        new CallerLife((MainObject) gameObject, new LogicColorShip(), g2d).drawLife();
    }

    private boolean isTarghetLife(final GameObject obj) {
        return !(obj instanceof SpaceShipSingleton || obj instanceof TakeableGameObject || obj instanceof Boss);
    }
    
    private void assignLifeBar(final GameObject gameObject, final Graphics2D g2d) {
        if (this.isTarghetLife(gameObject)) {
            this.drawLifeBar(g2d, gameObject);
        }
    }
    
    private AffineTransform getCorrectAffineTransformFromBoundingBox(final GameObject gameObject) {
        if (gameObject.getBoundingBox() instanceof CircleBoundingBox) {
            final AffineTransform transform = new AffineTransform();
            transform.setTransform(gameObject.getTransform());
            final CircleBoundingBox cbb = (CircleBoundingBox)gameObject.getBoundingBox();
            transform.translate(-cbb.getRadius(), -cbb.getRadius());
            return transform;
        }
        else {
            return gameObject.getTransform();
        }
    }

    private void updateGameObjects() {
        this.putObjectFromWorld();
        this.deletGameObject();

    }

    private void putObjectFromWorld() {
        this.world.get().getAllObjectsExceptBullets().forEach(obj -> {
            final Pair<Image, Image> pair = new Pair<>(obj.getImgBody(), obj.getImgEffect());
            this.objects.put(obj, pair);
        });
    }

    private void deletGameObject() {
        final Set<GameObject> objDelet = new HashSet<>();

        this.objects.forEach((key, value) -> {
            if (!this.world.get().getAllObjectsExceptBullets().contains(key)) {
                objDelet.add(key);
            }
        });

        objDelet.forEach(this.objects::remove);
    }

    public final void runUpdateGameObjects() {
        long lastTime = System.currentTimeMillis();
        while (true) {
            final long current = System.currentTimeMillis();

            if (this.world.isPresent()) {
               this.updateGameObjects();
            }

         waitForNextFrame(current);
           lastTime = current;
        }
    }

    protected final void waitForNextFrame(final long current) {
        final long dt = System.currentTimeMillis() - current;
        if (dt < EngineLoop.FPS) {
            ThreadUtils.sleep(EngineLoop.FPS - dt);
        }
    }

}
