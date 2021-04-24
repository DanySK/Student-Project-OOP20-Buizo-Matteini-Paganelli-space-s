package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;

public class DownReleaseCommand implements CommandMovement {

	@Override
	public void execute() {
		System.out.println("Release Down");

	}

}
