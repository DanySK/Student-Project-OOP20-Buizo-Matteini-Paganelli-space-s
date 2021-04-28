package CommandProva.ConcreteCommandAudio;

import CommandProva.CommandInterfaces.CommandAudio;
import sound.Sound;

public class StopSoundCommand implements CommandAudio {

	@Override
	public void execute(Sound sound) {
		System.out.println("Stop Sound");
		sound.stopClip();
	}
}