package model.sound;

import utilities.SoundType;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;


public class SoundEffect extends Sound {
	
	public SoundEffect() {
		super();
	}

	public SoundEffect(SoundType st) {
		super(st);
	}

	@Override
	protected void playSound(String fileName, double volume) {
		Thread thread = new Thread(() -> {
				System.out.println(fileName);
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
