import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.io.BufferedReader;

public class Main6 {
    /**
     * En este ejemplo se van procesando las líneas usando Stream y buffer
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        try ( BufferedReader buffer = Files.newBufferedReader(Paths.get(fileName),  StandardCharsets.UTF_8);
                Stream<String> stream = buffer.lines()) {
            stream.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
