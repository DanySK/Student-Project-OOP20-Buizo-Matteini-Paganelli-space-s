package spacesurvival.model.command.concreteCommand;

import spacesurvival.model.command.commandInterfaces.CommandGameObject;
import spacesurvival.model.gameobject.main.SpaceShipSingleton;
import spacesurvival.utilities.SoundPath;

public class SpaceBarCommand implements CommandGameObject {

    @Override
    public void execute(final SpaceShipSingleton ship) {
        ship.getWeapon().shoot();
        ship.pushEffect(SoundPath.SHOOT);
    }
}
