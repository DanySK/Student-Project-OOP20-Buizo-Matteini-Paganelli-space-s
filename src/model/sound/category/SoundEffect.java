package model.sound.category;

import model.sound.Sound;
import utilities.SoundPath;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;


public class SoundEffect extends Sound {
	
	public SoundEffect() {
		super();
	}

	public SoundEffect(final SoundPath st) {
		super(st);
	}

	@Override
	protected void playSound(final String fileName, final double volume) {
		Thread thread = new Thread(() -> {

			 	URL soundFile = ClassLoader.getSystemResource(fileName);
				AudioInputStream audioInputStream = null;
		        try {
		            audioInputStream = AudioSystem.getAudioInputStream(soundFile);

		            setClip(AudioSystem.getClip());
		            getClip().get().open(audioInputStream);

		            setVol(volume);
		            getClip().get().start();
		        }
		        catch (Exception e){
		            e.printStackTrace();
		        }
		});
	thread.start();
	}
	

}
