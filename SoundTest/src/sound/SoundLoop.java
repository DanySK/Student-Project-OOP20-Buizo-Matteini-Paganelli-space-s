package sound;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class SoundLoop extends Sound {
	
	public SoundLoop() {
		super();
	}
	
	public SoundLoop(SoundType st) {
		super(st);
	}

	@Override
	protected void playSound(String fileName, double volume) {

		Thread thread = new Thread() {
		public void run() {

			
				File soundFile = new File(fileName);
				AudioInputStream audioInputStream = null;
		        try {
					if(isPlaying()){
					stopClip();
					System.out.println(isPlaying());
					}
		            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
		             
		            setClip(AudioSystem.getClip());
		            getClip().get().open(audioInputStream);
		            getClip().get().loop(Clip.LOOP_CONTINUOUSLY);
		      
		            setVol(volume);
		            getClip().get().start();
		        } 
		        catch (Exception e){
		            e.printStackTrace();
		        }
		}	
	};
	thread.start();
	}
	

}
