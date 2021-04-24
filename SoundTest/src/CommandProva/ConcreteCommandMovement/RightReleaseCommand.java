package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;

public class RightReleaseCommand implements CommandMovement {

	@Override
	public void execute() {
		System.out.println("Release Right");

	}

}
