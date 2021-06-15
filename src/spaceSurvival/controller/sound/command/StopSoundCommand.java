package spaceSurvival.controller.sound.command;

import spaceSurvival.model.sound.Sound;

public class StopSoundCommand implements CommandAudio {

    @Override
    public void execute(final Sound sound) {
        sound.stopClip();
    }
}