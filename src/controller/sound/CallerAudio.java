package controller.sound;


import controller.sound.command.CommandAudio;
import controller.sound.command.PlaySoundCommand;
import controller.sound.command.StopSoundCommand;
import model.sound.CmdAudioType;
import model.sound.Sound;
import utilities.SoundPath;

public class CallerAudio {
	private final CommandAudio cmdAudioOn;
	private final CommandAudio cmdAudioOff;
	
	private Sound sound;
	
	public CallerAudio() {
		this.cmdAudioOn = new PlaySoundCommand();
		this.cmdAudioOff = new StopSoundCommand();
	}

	public CallerAudio(final Sound sound) {
		this();
		this.sound = sound;
	}

	public Sound getSound() {
		return this.sound;
	}
	
	public void setSound(final Sound sound) {
		this.sound = sound;
	}

	public void changeVolume(int currentVolume) {
		double parsedVolume = currentVolume / 100.0f;
		this.sound.setVol(parsedVolume);
	}

	public boolean isNewSound(final SoundPath sound){
		return this.sound.getSoundType() != sound;
	}
	
	public void execute(CmdAudioType cmd) {
		 switch(cmd) {
		 case AUDIO_ON:
		 	cmdAudioOn.execute(sound); break;
		 case AUDIO_OFF:
			 cmdAudioOff.execute(sound); break;
		 }
	}
}
