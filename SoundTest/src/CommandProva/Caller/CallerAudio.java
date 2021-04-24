package CommandProva.Caller;

import CommandProva.CmdType.CmdAudioType;
import CommandProva.CommandInterfaces.CommandAudio;
import CommandProva.ConcreteCommandAudio.PlaySoundCommand;
import CommandProva.ConcreteCommandAudio.StopSoundCommand;

public class CallerAudio {
	
	private final CommandAudio cmdAudioOn;
	private final CommandAudio cmdAudioOff;


	public CallerAudio() {
		this.cmdAudioOn = new PlaySoundCommand();
		this.cmdAudioOff = new StopSoundCommand();
	}
	
	public void execute(CmdAudioType cmd) {
		 switch(cmd) {
		 case AUDIO_ON:
			 cmdAudioOn.execute();
			 break;
		 case AUDIO_OFF:
			 cmdAudioOff.execute();
			 break;
		 }
	}
}
