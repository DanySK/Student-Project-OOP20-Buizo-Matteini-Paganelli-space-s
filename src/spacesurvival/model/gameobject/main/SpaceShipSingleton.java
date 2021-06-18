package spacesurvival.model.gameobject.main;

import spacesurvival.model.gameobject.Edge;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.Status;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.fireable.shootinglogic.FiringLogic;
import spacesurvival.model.gameobject.fireable.shootinglogic.implementation.NoFiringImpl;
import spacesurvival.model.gameobject.fireable.weapon.Weapon;
import spacesurvival.model.gameobject.movable.movement.MovementLogic;
import spacesurvival.model.gameobject.movable.movement.implementation.ControlledMovement;
import spacesurvival.model.gameobject.takeable.ammo.Ammo;
import spacesurvival.model.worldevent.WorldEvent;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import spacesurvival.model.EngineImage;
import spacesurvival.model.World;
import spacesurvival.model.collision.bounding.BoundingBox;
import spacesurvival.model.collision.bounding.RectBoundingBox;
import spacesurvival.model.collision.event.EventType;
import spacesurvival.model.collision.event.hit.HitBorderEvent;
import spacesurvival.model.collision.event.hit.HitMainGameObject;
import spacesurvival.model.collision.eventgenerator.PhysicsComponent;
import spacesurvival.model.collision.eventgenerator.ShipComponent;
import spacesurvival.utilities.Score;
import spacesurvival.utilities.dimension.ScaleOf;
import spacesurvival.utilities.dimension.Screen;
import spacesurvival.utilities.gameobject.DamageUtils;
import spacesurvival.utilities.gameobject.LifeUtils;
import spacesurvival.utilities.gameobject.VelocityUtils;
import spacesurvival.utilities.path.SoundPath;
import spacesurvival.utilities.path.animation.AnimationShip;

public final class SpaceShipSingleton extends FireableObject {

    private List<SoundPath> soundQueue = new LinkedList<>();

    // Eager and unique instance of this class for Threadsafing
    private static SpaceShipSingleton spaceShip = new SpaceShipSingleton(
            new EngineImage(ScaleOf.GAME_OBJECT, Screen.WIDTH_FULL_SCREEN, AnimationShip.NORMAL0),
            Screen.POINT_CENTER_FULLSCREEN,
            new RectBoundingBox(),
            new ShipComponent(),
            VelocityUtils.SPACESHIP_VEL,
            VelocityUtils.SPACESHIP_ACCELERATION,
            new ControlledMovement(),
            LifeUtils.SPACESHIP_LIFE,
            DamageUtils.SPACESHIP_DAMAGE,
            Score.SHIP,
            Optional.empty(),
            new Weapon(),
            new NoFiringImpl()
            );

    /** 
    * Invisible class constructor specifying space ship initial position and image path.
    */
    private SpaceShipSingleton(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final double acceleration, final MovementLogic movementLogic, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final FiringLogic firingLogic) {
        super(engineImage, position, bb, phys, velocity, acceleration, movementLogic, life, impactDamage, score, target, weapon, firingLogic);
        this.setBoundingBox(RectBoundingBox.createRectBoundingBox(position, engineImage, this.getTransform()));
    }

    /**
     * @return space ship static instance
     */
    public static SpaceShipSingleton getSpaceShip() {
        return spaceShip;
    }

    /**
     * Sets the ammo type taken from ship to its weapon.
     *
     * @param ammo the ammo taken from ship 
     */
    public void take(final Ammo ammo) {
        System.out.println("PRENDO MUNIZIONI DI TIPO " + ammo.getType());
        this.getWeapon().setAmmoType(ammo.getType());
    }

    @Override
    public void collided(final World world, final WorldEvent ev) {
        final Optional<EventType> evType = EventType.getEventFromHit(ev);
        if (evType.isPresent()) {
            switch (EventType.getEventFromHit(ev).get()) {
            case BORDER_EVENT:
                final HitBorderEvent hitBorderEvent = (HitBorderEvent) ev;
                final Edge edge = hitBorderEvent.getEdge();
                world.getSoundQueue().add(SoundPath.WALL_COLLISION);
                world.pacmanEffect(this, edge);
                break;
            case MAIN_GAME_OBJECT_EVENT:
                final HitMainGameObject asteroidEvent = (HitMainGameObject) ev;
                final MainObject collidedObject = asteroidEvent.getCollidedObject();
                if (!this.isInvincible()) {
                    world.getQueueDecreaseLife().add(collidedObject.getImpactDamage());
                    this.setStatus(Status.INVINCIBLE);
                }
                break;
            case DEAD_EVENT:
                world.getSoundQueue().add(SoundPath.LIFE_DOWN);
                break;
            default:
                break;
            }
        }
    }

    public List<SoundPath> getSoundQueue() {
        return soundQueue;
    }

    public void setSoundQueue(final List<SoundPath> soundQueue) {
        this.soundQueue = soundQueue;
    }

}

