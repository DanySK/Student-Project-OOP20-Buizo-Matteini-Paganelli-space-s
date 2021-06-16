package spacesurvival.controller.sound;

import spacesurvival.controller.sound.command.CommandAudio;
import spacesurvival.controller.sound.command.PlaySoundCommand;
import spacesurvival.controller.sound.command.ResetTiming;
import spacesurvival.controller.sound.command.StopSoundCommand;
import spacesurvival.model.sound.CmdAudioType;
import spacesurvival.model.sound.Sound;
import spacesurvival.utilities.SoundPath;

public class CallerAudio {
    private final CommandAudio cmdAudioOn;
    private final CommandAudio cmdAudioOff;
    private final CommandAudio cmdResetTiming;
	
    private Sound sound;
	
    public CallerAudio() {
	this.cmdAudioOn = new PlaySoundCommand();
	this.cmdAudioOff = new StopSoundCommand();
	this.cmdResetTiming = new ResetTiming();
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
        case RESET_TIMING:
            cmdResetTiming.execute(sound); break;
        default:
        cmdResetTiming.execute(sound); break;
        }
    }
	
    @Override
    public String toString() {
        return "CallerAudio{" +
                "CommandAudio= cmdAudioOn, cmdAudioOff, cmdResetTiming, "
                + "sound=" + this.getSound().toString() + '}';
    }
}
