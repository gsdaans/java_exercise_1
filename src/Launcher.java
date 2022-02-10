import java.util.Objects;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome !\nType a command :");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String instruction = scanner.nextLine();
            if (Objects.equals(instruction, "quit"))
                break;
            else System.out.println("Unknown command");
        }
    }
}
