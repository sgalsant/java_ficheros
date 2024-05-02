import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main5 {
    /**
     * En este ejemplo se van procesando las líneas usando Stream
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        try (Stream<String> stream = Files.lines(Path.of(fileName), StandardCharsets.UTF_8)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
