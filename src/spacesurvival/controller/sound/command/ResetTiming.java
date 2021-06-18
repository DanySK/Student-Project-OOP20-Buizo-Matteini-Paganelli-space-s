package spacesurvival.controller.sound.command;

import spacesurvival.model.sound.Sound;

public class ResetTiming implements CommandAudio {

    /** 
     * Reset the timing of the passed sound.
     * @param sound the sound on which the timing will be reset.
     * 
     */
    @Override
    public void execute(final Sound sound) {
        sound.getClip().get().setMicrosecondPosition(0);
    }
}
