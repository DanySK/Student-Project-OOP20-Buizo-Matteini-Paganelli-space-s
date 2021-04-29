package CommandProva.CmdType;

public enum CmdMovementType {
	
	KEY_LEFT  			(37),
	KEY_UP  			(38),
	KEY_RIGHT  			(39),
	KEY_DOWN  			(40);

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
