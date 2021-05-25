package spaceSurvival.controller.sound.command;

import spaceSurvival.model.sound.Sound;

public class ResetTiming implements CommandAudio {

	@Override
	public void execute(Sound sound) {
		System.out.println("Reset Sound");
		sound.getClip().get().setMicrosecondPosition(0);
	}

}
