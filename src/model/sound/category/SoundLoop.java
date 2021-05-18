package model.sound.category;

import model.sound.Sound;
import utilities.SoundPath;

import javax.sound.sampled.Clip;


public class SoundLoop extends Sound {
	
	public SoundLoop() {
		super();
	}
	
	public SoundLoop(SoundPath st) {
		super(st);

	}

	@Override
	protected void playSound(double volume) {
		setVol(volume);
		super.getClip().get().loop(Clip.LOOP_CONTINUOUSLY);
		super.getClip().get().start();
	}
	

}
