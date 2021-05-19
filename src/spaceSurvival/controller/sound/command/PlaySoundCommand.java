package spaceSurvival.controller.sound.command;

import spaceSurvival.model.sound.Sound;

public class PlaySoundCommand implements CommandAudio {

	@Override
	public void execute(Sound sound) {
		System.out.println("Start Sound");
		sound.startClip();
	}
}
