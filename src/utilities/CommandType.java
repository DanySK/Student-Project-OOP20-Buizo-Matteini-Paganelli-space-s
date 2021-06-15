package utilities;

import java.util.Optional;
import java.util.stream.Stream;

public enum CommandType {
	
    KEY_LEFT (37),
    KEY_UP  		(38),
    KEY_RIGHT  	        (39),
    KEY_SPACE_BAR		(32),
    KEY_A                   (65),
    KEY_W                   (69),
    KEY_D                   (68);

    private final Integer keyCode;

    CommandType(final Integer keyCode) {
        this.keyCode = keyCode;
    }

    public static Optional<CommandType> getValue(final Integer value) {
        return Stream.of(CommandType.values()).filter(cmd -> cmd.getKeyCode().equals(value)).findFirst();
    }

    public Integer getKeyCode() {
        return this.keyCode;
    }

}
