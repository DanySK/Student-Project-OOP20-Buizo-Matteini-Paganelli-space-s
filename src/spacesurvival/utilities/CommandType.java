package spacesurvival.utilities;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Class for the command type, all available keys and their key codes.
 *
 */
public enum CommandType {
    /**
     * Type of command to pass to the CallerCommand to rotate the spaceship left.
     */
    KEY_LEFT(37),
    /**
     * Type of command to pass to the CallerCommand to move forward the spaceship.
     */
    KEY_UP(38),
    /**
     * Type of command to pass to the CallerCommand to rotate the spaceship right.
     */
    KEY_RIGHT(39),
    /**
     * Type of command to pass to the CallerAudio to let the spaceship shot.
     */
    KEY_SPACE_BAR(32),
    /**
     * Type of command to pass to the CallerCommand to rotate the spaceship left.
     */
    KEY_A(65),
    /**
     * Type of command to pass to the CallerCommand to move forward the spaceship.
     */
    KEY_W(87),
    /**
     * Type of command to pass to the CallerCommand to rotate the spaceship right.
     */
    KEY_D(68);

    /**
     * Code of the relative character.
     */
    private final Integer keyCode;

    /**
     * Constructor for create enum associating a key code.
     */
    CommandType(final Integer keyCode) {
        this.keyCode = keyCode;
    }

    /**
     * Return an optional of CommandType from the passed value if present.
     * 
     * @param value int rapresenting the code of the key
     * @return the specific CommanType or an empty optional 
     */
    public static Optional<CommandType> getValue(final Integer value) {
        return Stream.of(CommandType.values()).filter(cmd -> cmd.getKeyCode().equals(value)).findFirst();
    }

    /**
     * Return the key code.
     * 
     * @return the specific key code
     */
    public Integer getKeyCode() {
        return this.keyCode;
    }

}
