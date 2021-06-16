package spaceSurvival.model.sound.category;

import spaceSurvival.model.sound.Sound;
import spaceSurvival.utilities.SoundPath;

import javax.sound.sampled.Clip;

public class SoundLoop extends Sound {
	
    public SoundLoop() {
        super();
    }
	
    public SoundLoop(final SoundPath st) {
        super(st);
    }

    /** 
     * Start the sound loop at the current volume.
     * @param volume the volume at which the sound loop will start in the range 0-100.
     */
    protected void playSound(final double volume) {
        setVolume(volume);
        super.getClip().get().loop(Clip.LOOP_CONTINUOUSLY);
        super.getClip().get().start();
    }
}
