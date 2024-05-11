import java.util.concurrent.TimeUnit;

public class StopWatch {
    private long startTime = 0;
    private long stopSeconds = 0;

    public void start() {
        if (!isStopped()) {
            System.out.println("Already started!");
            return;
        }
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        if (isStopped()) {
            System.out.println("StopWatch is already stopped!");
            return;
        }
        stopSeconds = getTimeInSeconds();
        startTime = 0;
    }

    public void reset() {
        if (startTime == 0 && stopSeconds == 0) {
            System.out.println("StopWatch isn't initialized!");
            return;
        }

        startTime = 0;
        stopSeconds = 0;
    }

    public long getTimeInSeconds() {
        if (isStopped())
            return stopSeconds;

        long timeInMillis = System.currentTimeMillis() - startTime;
        return TimeUnit.MILLISECONDS.toSeconds(timeInMillis) + stopSeconds;
    }

    private boolean isStopped() {
        return startTime == 0;
    }
}
