package CommandProva;

public enum CmdAudioType {
	
	AUDIO_ON  	("AUDIO_ON"),
	AUDIO_OFF  	("AUDIO_OFF");

	private final String string;

	CmdAudioType(String string) {
		this.string = string;
	}

	public String getValue() {
		return this.string;
	}

}