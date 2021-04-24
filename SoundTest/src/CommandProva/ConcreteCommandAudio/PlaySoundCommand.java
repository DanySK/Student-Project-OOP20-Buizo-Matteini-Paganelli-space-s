package CommandProva.ConcreteCommandAudio;

import CommandProva.CommandInterfaces.CommandAudio;

public class PlaySoundCommand implements CommandAudio {

	@Override
	public void execute() {
		System.out.println("Start Sound");
		
	}

}
