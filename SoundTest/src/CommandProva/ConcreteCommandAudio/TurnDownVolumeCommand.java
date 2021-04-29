package CommandProva.ConcreteCommandAudio;

import CommandProva.CommandInterfaces.CommandAudio;
import sound.Sound;

public class TurnDownVolumeCommand implements CommandAudio{

	@Override
	public void execute(Sound sound) {
		// TODO Auto-generated method stub
		sound.turnDownVol();
		
	}

}
