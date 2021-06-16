package spacesurvival.model.command.implementation;

import spacesurvival.model.command.CommandGameObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.SoundPath;

public class SpaceBarCommand implements CommandGameObject {

    @Override
    public void execute(final SpaceShipSingleton ship) {
        ship.getWeapon().shoot();
        ship.pushEffect(SoundPath.SHOOT);
    }
}
