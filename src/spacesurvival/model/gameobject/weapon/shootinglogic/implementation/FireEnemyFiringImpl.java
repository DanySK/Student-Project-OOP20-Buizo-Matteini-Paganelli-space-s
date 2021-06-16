package spacesurvival.model.gameobject.weapon.shootinglogic.implementation;

import spacesurvival.model.gameobject.GameObjectUtils;
import spacesurvival.model.gameobject.enemy.FireableObject;
import spacesurvival.model.gameobject.weapon.shootinglogic.FiringLogic;
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
