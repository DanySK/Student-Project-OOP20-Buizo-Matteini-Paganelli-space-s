package model.sound.category;

import model.sound.Sound;
import utilities.SoundPath;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class SoundEffect extends Sound {
	
	public SoundEffect() {
		super();
	}

	public SoundEffect(final SoundPath st) {
		super(st);
	}

	@Override
	protected void playSound(final double volume) {

		Thread thread = new Thread(() -> {
            //
            super.getClip().get().start();      
            setVol(volume);
		});
	thread.start();
	}
	

}
