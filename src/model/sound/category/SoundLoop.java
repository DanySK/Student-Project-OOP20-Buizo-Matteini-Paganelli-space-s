package model.sound.category;

import model.sound.Sound;
import utilities.SoundPath;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
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
		Thread thread = new Thread(() -> {
				
				super.getClip().get().loop(Clip.LOOP_CONTINUOUSLY);

				setVol(volume);
				super.getClip().get().start();

		});
	thread.start();
	}
	

}
