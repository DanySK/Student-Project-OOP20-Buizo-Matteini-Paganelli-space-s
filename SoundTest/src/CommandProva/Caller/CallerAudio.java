package CommandProva.Caller;

import CommandProva.CmdType.CmdAudioType;
import CommandProva.CommandInterfaces.CommandAudio;
import CommandProva.ConcreteCommandAudio.PlaySoundCommand;
import CommandProva.ConcreteCommandAudio.StopSoundCommand;
import CommandProva.ConcreteCommandAudio.TurnDownVolumeCommand;
import CommandProva.ConcreteCommandAudio.TurnUpVolumeCommand;
import sound.Sound;
//import utilities.SoundPath;

public class CallerAudio {
	
	private final CommandAudio cmdAudioOn;
	private final CommandAudio cmdAudioOff;
	private final CommandAudio cmdTurnUpVol;
	private final CommandAudio cmdTurnDownVol;
	
	private Sound sound;
	
	
	public CallerAudio() {
		this.cmdAudioOn = new PlaySoundCommand();
		this.cmdAudioOff = new StopSoundCommand();
		this.cmdTurnUpVol = new TurnUpVolumeCommand();
		this.cmdTurnDownVol = new TurnDownVolumeCommand();
		
		this.sound = null;
	}


	public CallerAudio(Sound sound) {
		this.cmdAudioOn = new PlaySoundCommand();
		this.cmdAudioOff = new StopSoundCommand();
		this.cmdTurnUpVol = new TurnUpVolumeCommand();
		this.cmdTurnDownVol = new TurnDownVolumeCommand();
		
		this.sound = sound;
		
	}
	
	public void setSound(Sound sound) {
		this.sound = sound;	
	}
	
	public Sound getSound() {
		return this.sound;	
	}
	
	public void changeVolume(int currentVolume) {
		
		System.out.println("Current Volume: " + currentVolume);
			
		double parsedVolume = currentVolume / 100.0f;	
		System.out.println("parsedVolume:" + parsedVolume);
		this.sound.setVol(parsedVolume);

	}
	
	public void execute(CmdAudioType cmd) {
		 switch(cmd) {
		 case AUDIO_ON:
			 cmdAudioOn.execute(this.sound);
			 break;
		 case AUDIO_OFF:
			 cmdAudioOff.execute(this.sound);
			 break;
		 case TURN_UP_VOLUME:
			 cmdTurnUpVol.execute(this.sound);
			 break;
		 case TURN_DOWN_VOLUME:
			 cmdTurnDownVol.execute(this.sound);
			 break;
		 }
	}
}
