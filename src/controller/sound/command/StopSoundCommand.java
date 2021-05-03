package controller.sound.command;


import model.sound.Sound;

public class StopSoundCommand implements CommandAudio {

	@Override
	public void execute(Sound sound) {
		System.out.println("Stop Sound");
		sound.stopClip();
	}
}