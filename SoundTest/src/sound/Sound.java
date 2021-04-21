package sound;

import java.util.Optional;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

	
abstract class Sound implements SoundObserver {


		private static final String FOLDER = "sounds/";
		private static final double START_VOLUME = 0.50;
	    private SoundType soundType;
	    private double volume;
	    private Optional<Clip> clip = Optional.empty();
	    

	    public Sound(SoundType sound) {
	    	this.soundType = sound;
	    	this.volume = START_VOLUME;
	    }
	    
	    public Sound() {
	    	this.soundType = null;
	    	this.volume = START_VOLUME;	
	    }
	    
	    public void setSoundType(SoundType sound) {
	    	this.soundType = sound;
	    }
	    
	    public SoundType getSoundType() {
	    	return this.soundType;
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
	    	
	    	if(this.clip.isPresent()) {
	    		return this.clip.get().isActive();
	    	}
	    	else {
	    		return false;
	    	}
	    	
	    }

	    
	    public void stopClip() {
	    	this.clip.get().stop();
	    }


	    public void startClip() {   	
	    	playSound(FOLDER + this.soundType.getValue(), this.volume);       
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

			return this.soundType.ordinal() < SoundType.GAME_SOUND.ordinal();
		}	
		
		
		public void update(SoundType st) {		
			setSoundType(st);
			startClip();		
		}
	
}
