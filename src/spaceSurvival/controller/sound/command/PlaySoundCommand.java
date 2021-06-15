package spaceSurvival.controller.sound.command;

import spaceSurvival.model.sound.Sound;

public class PlaySoundCommand implements CommandAudio {

    /** 
     * Start the passed sound.
     * @param sound the sound that will start.
     * 
     */
    public void execute(final Sound sound) {
        sound.startClip();
    }
}
