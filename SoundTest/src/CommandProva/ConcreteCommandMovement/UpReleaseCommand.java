package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;

public class UpReleaseCommand implements CommandMovement {

	@Override
	public void execute() {
		System.out.println("Release Up");

	}

}
