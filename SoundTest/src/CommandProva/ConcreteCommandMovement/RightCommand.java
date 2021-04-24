package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;

public class RightCommand implements CommandMovement{
	
	public RightCommand() {}

	@Override
	public void execute() {
		System.out.println("Right");
		
	}

}
