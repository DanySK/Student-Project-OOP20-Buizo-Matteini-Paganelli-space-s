package spacesurvival.model.gameobject.main;

import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.Edge;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.MainGameObject;
import spacesurvival.model.gameobject.Status;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.model.gameobject.weapon.Bullet;
import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.hitevent.EventType;
import spacesurvival.model.collision.hitevent.HitBorderEvent;
import spacesurvival.model.collision.hitevent.HitBulletEvent;
import spacesurvival.model.collision.hitevent.HitMainGameObject;
import spacesurvival.model.collision.physics.bounding.BoundingBox;
import spacesurvival.model.collision.physics.component.PhysicsComponent;

public class Asteroid extends MainGameObject {
	

    public Asteroid(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);
        this.setBoundingBox(GameObjectUtils.createCircleBoundingBox(position, engineImage, this.getTransform()));
    	initializeRotation();
    }

    public Asteroid(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final List<String> animation) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target);
        this.setBoundingBox(GameObjectUtils.createCircleBoundingBox(position, engineImage, this.getTransform()));
        this.setAnimation(animation);
        initializeRotation();
    }

    /**
     * Initialize a random rotation for the ateroid.
     */
    private void initializeRotation() {
        final Random random = new Random();
        final int randomAngle = random.nextInt(360);
        final AffineTransform at = getTransform();
        at.rotate(Math.toRadians(randomAngle), getSize().getWidth() / 2, getSize().getHeight() / 2);
        setTransform(at);
    }
    
    @Override
    public void manageEvent(final World world, final WorldEvent ev) {
        System.out.println("gestisco asteroid e evento" + EventType.getEventFromHit(ev));
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case BORDER_EVENT:
                final HitBorderEvent hitEvent = (HitBorderEvent) ev;
                final Edge edge = hitEvent.getEdge();
                this.pushEffect(SoundPath.WALL_COLLISION);
                world.pacmanEffect(this, edge);
                break;
            case BULLET_EVENT:
                final HitBulletEvent bulletEvent = (HitBulletEvent) ev;
                final Bullet bullet = bulletEvent.getBullet();
                //if (!bullet.getShooter().equals(this)) {
                bullet.stopAnimation();
                world.removeBullet(bullet);
                world.damageObject(this, bullet.getDamage(), bullet.getEffect().getStatus());
               // }
                break;
            case MAIN_GAME_OBJECT_EVENT:
                final HitMainGameObject mainEvent = (HitMainGameObject) ev;
                final MainGameObject collidedObj = mainEvent.getCollidedObject();
                world.damageObject(collidedObj, this.getImpactDamage(), Status.INVINCIBLE);
                world.damageObject(this, collidedObj.getImpactDamage(), Status.INVINCIBLE);
                break;
            case DEAD_EVENT:
                this.pushEffect(SoundPath.ASTEROID_EXPL);
                this.stopAnimation();
                world.removeAsteroid(this);
//                //this.controlGame.incrScore(Score.ASTEROID);
//                world.damageObject(this, collidedObject.getImpactDamage(), Status.INVINCIBLE);
//                world.damageObject(collidedObject, this.getImpactDamage(), Status.INVINCIBLE); 
                break;
            default:
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Asteroid { " + super.toString() + " }";
    }

}
