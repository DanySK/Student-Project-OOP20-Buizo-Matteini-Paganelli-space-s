package spaceSurvival.model.sound.category;

import spaceSurvival.model.sound.Sound;
import spaceSurvival.utilities.SoundPath;


public class SoundEffect extends Sound {
	
    public SoundEffect() {
        super();
    }

    public SoundEffect(final SoundPath st) {
        super(st);
    }

    /** 
     * Start the sound effect at the current volume.
     * @param volume the volume at which the sound effect will start in the range 0-100.
     */
    protected void playSound(final double volume) {
        super.getClip().get().start();
        setVolume(volume);
    }
}
