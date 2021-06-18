package spacesurvival.model.gameobject.fireable.shootinglogic.implementation;

import spacesurvival.model.gameobject.Status;
import spacesurvival.model.gameobject.fireable.FireableObject;
import spacesurvival.model.gameobject.fireable.shootinglogic.FiringLogic;
import spacesurvival.utilities.Delay;
import spacesurvival.utilities.ThreadUtils;

public class FireEnemyFiringImpl implements FiringLogic {

    @Override
    public void startFiring(final FireableObject fireableObject) {
        new Thread(() -> {
            while (fireableObject.isAlive()) {
                ThreadUtils.sleep(Delay.FIRE_ENEMY_FIRING);
                if (fireableObject.getStatus() != Status.PARALYZED) {
                    fireableObject.fire();
                }
            }
        }).start();
    }

    @Override
    public void startChangingAmmo(final FireableObject fireableObject) {
    }

}
