import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Console {
    private final Map<String, Runnable> commands = new HashMap<>();

    public void registerCommand(String name, Runnable cb) {
        commands.put(name, cb);
    }

    public void start() {
        var scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.next();

            if (input.equals("quit")) {
                scanner.close();
                break;
            }

            Runnable action = commands.get(input);

            if (action == null) {
                System.out.println("Command is not supported.");
                continue;
            }

            action.run();
        }

    }
}
