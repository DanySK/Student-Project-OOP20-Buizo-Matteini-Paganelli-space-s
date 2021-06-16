package spacesurvival.controller.sound.command;

import spacesurvival.model.sound.Sound;

public class StopSoundCommand implements CommandAudio {

    /** 
     * Stop the passed sound.
     * @param sound the sound that will stop.
     * 
     */
    public void execute(final Sound sound) {
        sound.stopClip();
    }
}
