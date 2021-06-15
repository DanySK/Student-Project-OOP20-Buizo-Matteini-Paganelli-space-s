package model.gameObject.enemy;

import java.util.Optional;
import model.gameObject.GameObjectUtils;
import model.movement.Movement;
import model.common.P2d;
import model.common.V2d;
import model.gameObject.weapon.Weapon;
import model.EngineImage;
import model.worldEcollisioni.physics.boundingType.BoundingBox;
import model.worldEcollisioni.physics.components.PhysicsComponent;

public class Boss extends FireableEnemy {

	public Boss(final EngineImage engineImage, final P2d position, final BoundingBox bb,
                final PhysicsComponent phys, final V2d velocity, final Movement movement, final int life,
                final int impactDamage, final Optional<Weapon> weapon, final int score, final P2d target) {		
		super(engineImage, position, bb, phys, velocity, movement, life, impactDamage, weapon, score, target);
    	this.setBoundingBox(GameObjectUtils.createRectBoundingBox(position, engineImage, this.getTransform()));
        new Thread(Boss.this::fire).start();
	}

	public void fire() {
	    while (true) {
	        try {
                sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
	        if (this.getWeapon().isPresent()) {
	            this.getWeapon().get().shoot();
	        }
        }
    }
	
	
	@Override
	public String toString() {
		return "Boss { " + super.toString() + " }";
	}

}
