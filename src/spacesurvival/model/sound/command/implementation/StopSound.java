package spacesurvival.model.sound.command.implementation;

import spacesurvival.model.sound.Sound;
import spacesurvival.model.sound.command.CommandAudio;

public class StopSound implements CommandAudio {

    /** 
     * Stop the passed sound.
     * @param sound the sound that will stop.
     * 
     */
    public void execute(final Sound sound) {
        sound.stopClip();
    }
}
