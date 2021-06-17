package spacesurvival.model.gameobject.fireable.shootinglogic.implementation;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.fireable.shootinglogic.FiringLogic;
import spacesurvival.utilities.ThreadUtils;

public class FireEnemyFiringImpl implements FiringLogic {

    @Override
    public void startFiring(final FireableObject fireableObject) {
        new Thread(() -> {
            while (fireableObject.isAlive()) {
                ThreadUtils.sleep(GameObjectUtils.FIRE_ENEMY_FIRING_DELAY);
                System.out.println("NEMICO SPARA");
                fireableObject.fire();
            }
        }).start();
    }

    @Override
    public void startChangingAmmo(final FireableObject fireableObject) {

    }

}
