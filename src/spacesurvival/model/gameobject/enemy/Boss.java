package spacesurvival.model.gameobject.enemy;

import java.util.List;
import java.util.Optional;
import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.movement.Movement;
import spacesurvival.model.common.P2d;
import spacesurvival.model.common.V2d;
import spacesurvival.model.gameobject.weapon.Weapon;
import spacesurvival.model.gameobject.weapon.shootinglogic.ShootingLogic;
import spacesurvival.model.EngineImage;
import spacesurvival.model.collisioni.physics.bounding.BoundingBox;
import spacesurvival.model.collisioni.physics.component.PhysicsComponent;

public class Boss extends FireableObject {

    public Boss(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final ShootingLogic shootingLogic, final List<String> animation) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target, weapon, shootingLogic);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
        this.setAnimation(animation);
//        new Thread(Boss.this::fire).start();
    }

    public Boss(final EngineImage engineImage, final P2d position, final BoundingBox bb,
            final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
            final int impactDamage, final int score, final Optional<P2d> target, final Weapon weapon,
            final ShootingLogic shootingLogic) {
        super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, score, target, weapon, shootingLogic);
        this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
//        new Thread(Boss.this::fire).start();
    }

    public void fire() {
        while (true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            this.getWeapon().shoot();
        }
    }

    @Override
    public String toString() {
        return "Boss { " + super.toString() + " }";
    }

}
