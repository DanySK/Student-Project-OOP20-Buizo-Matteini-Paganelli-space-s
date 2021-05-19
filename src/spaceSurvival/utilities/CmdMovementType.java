package spaceSurvival.utilities;

public enum CmdMovementType {
	
	KEY_LEFT  			(37),
	KEY_UP  			(38),
	KEY_RIGHT  			(39),
	KEY_DOWN  			(40),
	KEY_ROTATE_LEFT  	(81),
	KEY_ROTATE_RIGHT  	(69);

	private final Integer keyCode;

	CmdMovementType(Integer keyCode) {
		this.keyCode = keyCode;
	}
	

	public static CmdMovementType getValue(Integer value) {
		
		for(CmdMovementType cmd : CmdMovementType.values()) {
			if(cmd.keyCode == value) {
				return cmd;
			}
		}
		return null;
	}
	
	

}
