import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Objects;
import java.util.Scanner;

public class Launcher {

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
    public static void main(String[] args) {
        System.out.println("Welcome !Type a command :");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String instruction = scanner.nextLine();
            if (Objects.equals(instruction, "quit"))
                break;
            else if (Objects.equals(instruction, "fibo")) {
                System.out.println("Enter the index of Fibonacci value you want :");
                String rawNumber = scanner.nextLine();
                int fiboval = Integer.parseInt(rawNumber);
                System.out.println(fibo(fiboval));
            }
            else if (Objects.equals(instruction, "freq")) {
                System.out.println("Enter the file path");
                String pathString = scanner.nextLine();
                Path path = Paths.get(pathString);
                String text = "";
                if (!Files.exists(path)) {
                    System.out.println("Unreadable file: ");
                    continue;
                }
                try {
                    text = Files.readString(path);
                    text = text.replaceAll("[.!?\\-,\\n]", " ").toLowerCase(Locale.ROOT);
                    List<String> tab = List.of(text.split(" "));
                    Map<String, Long> list = tab.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                    Map<String, Long> result = list.entrySet().stream()
                            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                            .limit(3)
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
                    List<String> l = new ArrayList<>(result.keySet());
                    String res = String.join(" ", l);
                    System.out.println(res);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                continue;
            }
            else System.out.println("Unknown command");
        }
    }
}
