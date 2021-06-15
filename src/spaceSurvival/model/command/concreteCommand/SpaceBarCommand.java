package spaceSurvival.model.command.concreteCommand;

import spaceSurvival.model.command.commandInterfaces.CommandGameObject;
import spaceSurvival.model.gameObject.mainGameObject.SpaceShipSingleton;
import spaceSurvival.utilities.SoundPath;

public class SpaceBarCommand implements CommandGameObject{

	@Override
        public void execute(final SpaceShipSingleton ship) {

	    if (ship.getWeapon().isPresent()) {
		    ship.getWeapon().get().shoot();
		    ship.pushEffect(SoundPath.SHOOT);
		}	
	}
}
