package CommandProva.ConcreteCommandAudio;

import CommandProva.CommandInterfaces.CommandAudio;

public class StopSoundCommand implements CommandAudio {

	@Override
	public void execute() {
		System.out.println("Stop Sound");
	}
}