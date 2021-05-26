package spaceSurvival.model.sound;

import spaceSurvival.utilities.SoundPath;

import java.io.IOException;
import java.util.Optional;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

	
public abstract class Sound {
		private static final double START_VOLUME = 0.50;
	    private SoundPath soundPath;
	    private double volume;
	    private Optional<Clip> clip = Optional.empty();
	    private boolean isPlaying = false;

		public Sound() {
			this.soundPath = null;
			this.volume = START_VOLUME;
		}

	public double getVolume() {
		return volume;
	}

	public Sound(final SoundPath sound) {
	    	this.soundPath = sound;
	    	this.volume = START_VOLUME;
	    	
	    	AudioInputStream audioInputStream = null;
	    	
	    	try {
				audioInputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(sound.getPath()));
				setClip(AudioSystem.getClip());
				getClip().get().open(audioInputStream);
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	    
	    public void setSoundType(SoundPath sound) {
	    	this.soundPath = sound;
	    }
	    
	    public SoundPath getSoundType() {
	    	return this.soundPath;
	    }
	    
	    public void setClip(Clip clip) {
	    	this.clip = Optional.of(clip);
	    }
	    
	    public Optional<Clip> getClip() {
	    	return this.clip;
	    }
	    
	    public boolean isPlaying() {
	    	return this.isPlaying;
	    }
	    
	    
	    public void stopClip() {
	    	this.clip.get().stop();
	    	this.isPlaying = false;
	    }


	    public void startClip() {
			System.out.println("VOLUMENE DENTRO nel SOUND" + this.volume);
	    	playSound(this.volume);
	    	this.isPlaying = true;
	    }
	    
	    protected abstract void playSound(double volume);
	   
	    
		public void setVol(double volume) {
			this.volume = volume;
			FloatControl gain = (FloatControl) getClip().get().getControl(FloatControl.Type.MASTER_GAIN);

			float dB = (float) (Math.log(volume) / Math.log(10) * 20);
			gain.setValue(dB);
		}

}
