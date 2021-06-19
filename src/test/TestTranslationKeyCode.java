package test;

import static org.junit.Assert.assertEquals;
import java.util.Optional;
import org.junit.Test;
import spacesurvival.utilities.CommandType;

public class TestTranslationKeyCode {

    @Test
    public void testTranslationNotExist() {

        final Optional<CommandType> expectedValue = Optional.empty();
        final Optional<CommandType> currentValue = CommandType.getValue(1);
        assertEquals(expectedValue, currentValue);
    }

    @Test
    public void testTranslationExist() {

        final Optional<CommandType> expectedValue = Optional.of(CommandType.KEY_A);
        final Optional<CommandType> currentValue = CommandType.getValue(CommandType.KEY_A.getKeyCode());
        assertEquals(expectedValue.get(), currentValue.get());
    }

}
