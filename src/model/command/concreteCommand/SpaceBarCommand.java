package model.command.concreteCommand;

import model.command.commandInterfaces.CommandGameObject;
import model.gameObject.MainGameObject;
import utilities.SoundPath;

public class SpaceBarCommand implements CommandGameObject{
	
	public SpaceBarCommand() {}

	@Override
	public void execute(MainGameObject object) {
		System.out.println(object.getWeapon().isPresent());
		if (object.getWeapon().isPresent()) {
			object.getWeapon().get().shoot();
			object.pushEffect(SoundPath.SHOOT);
		}	
	}
	
}
