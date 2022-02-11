import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Fibo implements Command {

    @Override
    public String name() {
        return "fibo";
    }

    public static int fibo(int n) {
        if (n <0)
            throw new IllegalArgumentException("Number should be positive");
        if (Objects.equals(n, 0))
            return 0;
        if (Objects.equals(n, 1))
            return 1;
        if (n > 1)
            return (fibo(n-1) + fibo(n - 2));
        return n;
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter the index of Fibonacci value you want :");
        String rawNumber = scanner.nextLine();
        int fiboval = Integer.parseInt(rawNumber);
        System.out.println(fibo(fiboval));
        return true;
    }
}