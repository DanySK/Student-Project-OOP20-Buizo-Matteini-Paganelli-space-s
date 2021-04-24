package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;

public class LeftCommand implements CommandMovement{
	
	public LeftCommand() {}

	@Override
	public void execute() {
		System.out.println("Left");
		
	}


}
