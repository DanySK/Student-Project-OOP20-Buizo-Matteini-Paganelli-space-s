package spaceSurvival.controller.sound.command;

import spaceSurvival.model.sound.Sound;

public class ResetTiming implements CommandAudio {

    @Override
    public void execute(final Sound sound) {
        sound.getClip().get().setMicrosecondPosition(0);
    }

}
