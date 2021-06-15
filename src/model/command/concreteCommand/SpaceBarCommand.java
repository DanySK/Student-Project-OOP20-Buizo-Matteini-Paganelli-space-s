package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.MainGameObject;
import utilities.SoundPath;


public class SpaceBarCommand implements CommandGameObject {

    @Override
    public void execute(final MainGameObject ship) {
        if (ship.getWeapon().isPresent()) {
            ship.getWeapon().get().shoot();
            ship.pushEffect(SoundPath.SHOOT);
        }	
    }
}
