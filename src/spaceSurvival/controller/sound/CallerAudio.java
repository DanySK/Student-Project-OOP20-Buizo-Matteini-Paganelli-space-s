package spaceSurvival.controller.sound;


import spaceSurvival.controller.sound.command.CommandAudio;
import spaceSurvival.controller.sound.command.PlaySoundCommand;
import spaceSurvival.controller.sound.command.StopSoundCommand;
import spaceSurvival.model.sound.CmdAudioType;
import spaceSurvival.model.sound.Sound;
import spaceSurvival.utilities.SoundPath;

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
