package model.sound;

import utilities.SoundPath;

import java.util.Optional;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

	
public abstract class Sound implements SoundObserver {
		private static final double START_VOLUME = 0.50;
	    private SoundPath soundPath;
	    private double volume;
	    private Optional<Clip> clip = Optional.empty();
	    

	    public Sound(SoundPath sound) {
	    	this.soundPath = sound;
	    	this.volume = START_VOLUME;
	    }
	    
	    public Sound() {
	    	this.soundPath = null;
	    	this.volume = START_VOLUME;	
	    }
	    
	    public void setSoundType(SoundPath sound) {
	    	this.soundPath = sound;
	    }
	    
	    public SoundPath getSoundType() {
	    	return this.soundPath;
	    }
	    
	    public void setClip(Clip clip) {
	    	System.out.println(Optional.of(clip));
	    	this.clip = Optional.of(clip);
	    	System.out.println(this.clip.get());
	    }
	    
	    public Optional<Clip> getClip() {
	    	return this.clip;
	    }
	    
	    public boolean isPlaying() {
			return this.clip.map(DataLine::isActive).orElse(false);
	    	
	    }

	    
	    public void stopClip() {
	    	this.clip.get().stop();
	    }


	    public void startClip() {   	
	    	playSound(this.soundPath.getValue(), this.volume);
	    }
	    
	    protected abstract void playSound(String fileName, double volume);

	   
	    
		public void setVol(double volume) {
			FloatControl gain = null;

			System.out.println(getClip().get());
			
			gain = (FloatControl) getClip().get().getControl(FloatControl.Type.MASTER_GAIN);
		
			float dB = (float) (Math.log(volume) / Math.log(10) * 20);
			gain.setValue(dB);
			
		}	
		
		public boolean isLoop() {
			return this.soundPath.ordinal() < SoundPath.GAME_SOUND.ordinal();
		}	
		
		
		public void update(SoundPath st) {
			setSoundType(st);
			startClip();		
		}
	
}
