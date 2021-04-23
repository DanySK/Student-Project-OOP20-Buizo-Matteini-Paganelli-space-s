package CommandProva;

public enum CmdGameType {
	
	EXIT  	("EXIT");

	private final String string;

	CmdGameType(String string) {
		this.string = string;
	}

	public String getValue() {
		return this.string;
	}

}
