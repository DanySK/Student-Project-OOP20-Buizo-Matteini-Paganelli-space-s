package spaceSurvival.controller.sound.command;

import spaceSurvival.model.sound.Sound;

public class ResetTiming implements CommandAudio {

    /** 
     * Reset the timing of the passed sound.
     * @param sound the sound on which the timing will be reset.
     * 
     */
    public void execute(final Sound sound) {
        sound.getClip().get().setMicrosecondPosition(0);
    }

}
