package spacesurvival.model.sound.category;

import spacesurvival.model.sound.Sound;
import spacesurvival.utilities.SoundPath;
import javax.sound.sampled.Clip;

public class SoundLoop extends Sound {
	
    public SoundLoop() {
        super();
    }
	
    public SoundLoop(final SoundPath st) {
        super(st);
    }

    @Override
    protected void playSound(final double volume) {
        setVol(volume);
        super.getClip().get().loop(Clip.LOOP_CONTINUOUSLY);
        super.getClip().get().start();
    }
}
