package spacesurvival.controller.sound.command;

import spacesurvival.model.sound.Sound;

public interface CommandAudio {

    /** 
     * Execute the specified command on the passed sound.
     * @param sound the sound on which the command will be executed.
     * 
     */
    void execute(Sound sound);
}
