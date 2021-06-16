package spacesurvival.model.sound;

public enum CmdAudioType {
	
    AUDIO_ON       ("AUDIO_ON"),
    AUDIO_OFF      ("AUDIO_OFF"), 
    RESET_TIMING   ("RESET_TIMING");

    private final String string;

    CmdAudioType(final String string) {
        this.string = string;
    }

    public String getValue() {
        return this.string;
    }

}