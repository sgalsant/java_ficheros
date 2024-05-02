import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Main7 {
    /**
     * Ejemplo de tratamiento de ficheros de texto usando Stream con Buffer y filtrando las líneas 🦄
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        try (BufferedReader buffer = Files.newBufferedReader(Paths.get(fileName),  StandardCharsets.UTF_8);
             Stream<String> stream = buffer.lines()) {
            stream
                 .filter(line -> line.indexOf(",BEST PICTURE,True") > 0)
                 .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}

