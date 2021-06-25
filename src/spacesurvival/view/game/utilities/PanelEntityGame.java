package spacesurvival.view.game.utilities;

import spacesurvival.model.World;
import spacesurvival.model.collision.bounding.CircleBoundingBox;
import spacesurvival.model.common.Pair;
import spacesurvival.model.gameobject.GameObject;
import spacesurvival.model.EngineLoop;
import spacesurvival.model.gameobject.fireable.Boss;
import spacesurvival.model.gameobject.fireable.SpaceShipSingleton;
import spacesurvival.model.gameobject.main.MainObject;
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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import javax.swing.JPanel;

public class PanelEntityGame extends JPanel {

    private static final long serialVersionUID = -6158413043296871948L;

    public static final int ANCHOR_X_LIFE_BAR = 0;
    public static final int HEIGHT_LIFE_BAR = 6;
    public static final int HEIGHT_LIFE = 5;
    public static final int DIFFERENCE_HEIGHT_LIFE_BAR = Math.abs(HEIGHT_LIFE_BAR - HEIGHT_LIFE);

    private Map<GameObject, Pair<Image, Image>> gameObjects;
    private Optional<World> world;

    public PanelEntityGame() {
        super(); 
        super.setOpaque(true);
        super.setBackground(new Color(3, 88, 149));
        //super.setBackground(Background.TRANSPARENT);
        this.gameObjects = new HashMap<>();
        this.world = Optional.empty();

        new Thread(PanelEntityGame.this::runUpdateGameObjects).start();
    }

    public void setWorld(final World world) {
        this.world = Optional.of(world);
    }

    @Override
    public final void paintComponent(final Graphics g) {
        super.paintComponent(g);
        final Graphics2D g2d = (Graphics2D) g;

//        final Iterator<Entry<GameObject, Pair<Image, Image>>> entitiesIterator = this.gameObjects.entrySet().iterator();
//
//        while (entitiesIterator.hasNext()) {
//            final Entry<GameObject, Pair<Image, Image>> entity = entitiesIterator.next();
//            g2d.setTransform(getCorrectAffineTransformFromBoundingBox(entity.getKey())); 
//            g2d.drawImage(entity.getValue().getX(), 0, 0, null);
//            g2d.drawImage(entity.getValue().getY(), 0, 0, null);
//            this.assignLifeBar(entity.getKey(), g2d);
//        }

        this.gameObjects.entrySet().forEach(entity -> {
            g2d.setTransform(getCorrectAffineTransformFromBoundingBox(entity.getKey())); 
            g2d.drawImage(entity.getValue().getX(), 0, 0, null);
            g2d.drawImage(entity.getValue().getY(), 0, 0, null);
            this.assignLifeBar(entity.getKey(), g2d);
        });
        
        this.world.get().getAllBullets().forEach(bullet -> {
            g2d.setTransform(bullet.getTransform());
            g2d.drawImage(bullet.getImgBody(), 0, 0, null);
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

    private boolean isTargetLife(final GameObject obj) {
        return !(obj instanceof SpaceShipSingleton || obj instanceof TakeableGameObject || obj instanceof Boss);
    }
    
    private void assignLifeBar(final GameObject gameObject, final Graphics2D g2d) {
        if (this.isTargetLife(gameObject)) {
            this.drawLifeBar(g2d, gameObject);
        }
    }
    
    private AffineTransform getCorrectAffineTransformFromBoundingBox(final GameObject gameObject) {
        if (gameObject.getBoundingBox() instanceof CircleBoundingBox) {
            final CircleBoundingBox cbb = (CircleBoundingBox)gameObject.getBoundingBox();
            final AffineTransform transform = new AffineTransform();
            transform.setTransform(gameObject.getTransform());
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
            this.gameObjects.put(obj, pair);
        });
    }

    private void deletGameObject() {
        final Set<GameObject> objDelet = new HashSet<>();

        this.gameObjects.forEach((key, value) -> {
            if (!this.world.get().getAllObjectsExceptBullets().contains(key)) {
                objDelet.add(key);
            }
        });

        objDelet.forEach(this.gameObjects::remove);
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
