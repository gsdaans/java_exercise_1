import java.util.Objects;
import java.util.Scanner;

public class Launcher {
    public static void main(String[] args) {
        System.out.println("Welcome !\nType a command :");

        Scanner scanner = new Scanner(System.in);

        String instruction = scanner.nextLine();
        if (!Objects.equals(instruction, "quit"))
            System.out.println("Unknown command");
    }
}
