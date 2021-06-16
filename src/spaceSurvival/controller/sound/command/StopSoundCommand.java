package spacesurvival.controller.sound.command;

import spacesurvival.model.sound.Sound;

public class StopSoundCommand implements CommandAudio {

    @Override
    public void execute(final Sound sound) {
        sound.stopClip();
    }
}