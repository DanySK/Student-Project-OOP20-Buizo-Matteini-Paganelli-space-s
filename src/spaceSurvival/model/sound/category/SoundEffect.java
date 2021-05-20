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

	@Override
	protected void playSound(final double volume) {
		super.getClip().get().start();
		setVol(volume);
	}
	

}