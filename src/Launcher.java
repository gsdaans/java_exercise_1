import java.util.*;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome");
        Scanner scanner = new Scanner(System.in);
        List<Command> commands = new ArrayList<Command>();
        commands.add(new Fibo());
        commands.add(new Freq());
        commands.add(new Quit());
        commands.add(new Predict());
        boolean isRunning = false;
        while (!isRunning) {
            System.out.println("Enter command :");
            String input = scanner.nextLine();
            Command command = commands.stream().filter(cmd -> input.equals(cmd.name())).findAny().orElse(null);

            if (Objects.isNull(command)) {
                System.out.println("Unknown command");
            }
            else {
                isRunning = command.run(scanner);
            }
        }
        scanner.close();
    }
}
