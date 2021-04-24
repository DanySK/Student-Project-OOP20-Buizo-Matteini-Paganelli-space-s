package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;

public class LeftReleaseCommand implements CommandMovement {

	@Override
	public void execute() {
		System.out.println("Release Left");

	}

}
