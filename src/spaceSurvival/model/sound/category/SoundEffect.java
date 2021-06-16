package spacesurvival.model.sound.category;

import spacesurvival.model.sound.Sound;
import spacesurvival.utilities.SoundPath;


public class SoundEffect extends Sound {
	
    public SoundEffect() {
        super();
    }

    public SoundEffect(final SoundPath st) {
        super(st);
    }

    @Override
    protected void playSound(final double volume) {
        super.getClip().get().start();
        setVol(volume);
    }
}
