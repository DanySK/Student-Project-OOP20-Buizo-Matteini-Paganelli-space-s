package spacesurvival.utilities;

public final class ThreadUtils {

    private ThreadUtils() {
    }

    public static void sleep(final long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
