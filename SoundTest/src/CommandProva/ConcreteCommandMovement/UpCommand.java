package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;

public class UpCommand implements CommandMovement{
	
	public UpCommand() {}

	@Override
	public void execute() {
		System.out.println("Up");
		
	}

}
