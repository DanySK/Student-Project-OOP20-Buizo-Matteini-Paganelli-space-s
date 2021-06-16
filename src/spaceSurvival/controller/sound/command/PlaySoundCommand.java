package spacesurvival.controller.sound.command;

import spacesurvival.model.sound.Sound;

public class PlaySoundCommand implements CommandAudio {

    @Override
    public void execute(final Sound sound) {
        sound.startClip();
    }
}
