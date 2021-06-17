package spacesurvival.utilities.path;

import java.nio.file.Paths;

public final class Helps {

    /**
     * WASD help image.
     */
    public static final String WASD = Paths.get(MainFolder.HELP, "wasd.png").toString();
    /**
     * Row help image.
     */
    public static final String ROW = Paths.get(MainFolder.HELP, "row.png").toString();
    /**
     * Spacebar help image.
     */
    public static final String SPACEBAR = Paths.get(MainFolder.HELP, "space.png").toString();
    /**
     * Key K help image.
     */
    public static final String KEY_K = Paths.get(MainFolder.HELP, "key_K.png").toString();
    /**
     * Key P help image.
     */
    public static final String KEY_P = Paths.get(MainFolder.HELP, "key_P.png").toString();
    /**
     * Pause key help image.
     */
    public static final String PAUSE_KEY = Paths.get(MainFolder.HELP, "pause.png").toString();

    private Helps() {

    }
}
