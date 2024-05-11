public class Main {
    public static void main(String[] args) {
        var console = new Console();
        var stopWatch = new StopWatch();

        console.registerCommand("start", stopWatch::start);
        console.registerCommand("stop", stopWatch::stop);
        console.registerCommand("reset", stopWatch::reset);
        console.registerCommand("seconds", () -> System.out.println(stopWatch.getTimeInSeconds()));

        console.start();
    }
}