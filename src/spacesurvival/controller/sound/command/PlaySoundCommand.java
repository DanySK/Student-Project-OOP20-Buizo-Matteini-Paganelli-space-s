package spacesurvival.controller.sound.command;

import spacesurvival.model.sound.Sound;

public class PlaySoundCommand implements CommandAudio {

    /** 
     * Start the passed sound.
     * @param sound the sound that will start.
     * 
     */
    @Override
    public void execute(final Sound sound) {
        sound.startClip();
    }
}
