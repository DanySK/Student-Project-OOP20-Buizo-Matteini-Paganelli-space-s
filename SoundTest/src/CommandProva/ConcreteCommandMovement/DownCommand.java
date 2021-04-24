package CommandProva.ConcreteCommandMovement;

import CommandProva.CommandInterfaces.CommandMovement;

public class DownCommand implements CommandMovement{
	
	public DownCommand() {}

	@Override
	public void execute() {
		System.out.println("Down");
		
	}


}
