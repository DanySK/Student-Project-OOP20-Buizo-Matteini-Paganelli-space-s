package spacesurvival.utilities;

public final class ThreadUtils {

    /**
     * Empty constructor for ThreadUtils.
     */
    private ThreadUtils() {
    }

    /**
     * Sleep method for the thread.
     * 
     * @param milliseconds milliseconds to sleep
     */
    public static void sleep(final long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
