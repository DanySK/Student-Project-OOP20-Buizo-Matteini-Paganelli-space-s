package spaceSurvival.utilities;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum SoundType {
    LOOP , 
    EFFECT;

    public List<SoundPath> getSoundPaths() {
        return Stream.of(SoundPath.values()).filter(path -> path.getType().equals(this)).collect(Collectors.toList());
    }
}