package spaceSurvival.model.sound;

public enum CmdAudioType {
    /** 
     * Type of command to pass to the CallerAudio to start sound.
     */
    AUDIO_ON("AUDIO_ON"),
    /**
     * Type of command to pass to the CallerAudio to stop sound.
     */
    AUDIO_OFF("AUDIO_OFF"), 
    /**
     * Type of command to pass to the CallerAudio to reset the timing of the sound.
     */
    RESET_TIMING("RESET_TIMING");

    private final String string;

    CmdAudioType(final String string) {
        this.string = string;
    }

    /**
     * Type of command to pass to the CallerAudio to reset the timing of the sound.
     * 
     * @return the string rapresenting the command.
     */
    public String getValue() {
        return this.string;
    }

}