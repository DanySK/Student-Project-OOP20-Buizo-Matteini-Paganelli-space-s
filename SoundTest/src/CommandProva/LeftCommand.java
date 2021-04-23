package CommandProva;

public class LeftCommand implements CommandMovement{
	
	public LeftCommand() {}

	@Override
	public void execute() {
		System.out.println("Left");
		
	}


}
