
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command{

    @Override
    public String name() {
        return "freq";
    }

    @Override
    public boolean run(Scanner scanner) {
        System.out.println("Enter the file path");
        String pathString = scanner.nextLine();
        Path path = Paths.get(pathString);
        try {
            String text = Files.readString(path);
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
            System.out.println("Unreadable file: " + e.getClass() + " " + e.getMessage());
            return false;
        }
        return true;
    }
}