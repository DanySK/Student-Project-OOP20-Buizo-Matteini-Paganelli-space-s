package spaceSurvival.utilities;

public enum CommandType {
	
	KEY_LEFT  			(37),
	KEY_UP  			(38),
	KEY_RIGHT  			(39),
	KEY_DOWN  			(40),
	KEY_ROTATE_LEFT  	(81),
	KEY_ROTATE_RIGHT  	(69),
	KEY_SPACE_BAR		(32);

	private final Integer keyCode;

	CommandType(Integer keyCode) {
		this.keyCode = keyCode;
	}

	public static CommandType getValue(Integer value) {
		for(CommandType cmd : CommandType.values()) {
			if(cmd.keyCode.equals(value)) {
				return cmd;
			}
		}
		return null;
	}

}
