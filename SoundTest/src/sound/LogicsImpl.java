package sound;

import sound.category.SoundEffect;
import sound.category.SoundLoop;
import utilities.SoundPath;

public class LogicsImpl implements Logics {
	private Sound backgroundSound;
	private Sound effectSound;
	
    public LogicsImpl(){
    	this.backgroundSound = new SoundLoop();
    	this.effectSound = new SoundEffect();
    	
	}

	public LogicsImpl(SoundPath st){
    	this.backgroundSound = new SoundLoop(st);
    	this.effectSound = new SoundEffect(st);
	}
    

	public Sound getSoundLoop(){
    	return this.backgroundSound;
    }
	
	public Sound getSoundEffect(){
    	return this.effectSound;
    }
    
    public void setSoundLoop(Sound newSoundLoop){
    	this.backgroundSound = newSoundLoop;
    }
    
	public void setSoundEffect(Sound newSoundEffect){
    	this.effectSound = newSoundEffect;
    }
   
//	@Override
//	public void changeVolume(int currentVolume) {
//		
//		System.out.println("Current Volume: " + currentVolume);
//			
//		double parsedVolume = currentVolume / 100.0f;	
//		System.out.println("parsedVolume:" + parsedVolume);
//		backgroundSound.setVol(parsedVolume);
//
//	}
}

