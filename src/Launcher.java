import java.util.Objects;
import java.util.Scanner;

public class Launcher {
    public static int fibo(int n) {
        if (Objects.equals(n, 0))
            return 0;
        if (Objects.equals(n, 1))
            return 1;
        if (n > 1)
            return (fibo(n-1) + fibo(n - 2));
        return n;
    }
    public static void main(String[] args) {
        System.out.println("Welcome !\nType a command :");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String instruction = scanner.nextLine();
            if (Objects.equals(instruction, "quit"))
                break;
            else if (Objects.equals(instruction, "fibo")) {
                System.out.println("Enter the index of Fibonacci value you want :");
                int fiboval = scanner.nextInt();
                instruction = scanner.nextLine();
                System.out.println(fibo(fiboval));
            }
            else System.out.println("Unknown command");
        }
    }
}
