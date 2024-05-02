import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Main8 {
    /**
     * Ejemplo Uso de Stream para leer ficheros de texto empleando expresiones regulares  🍺
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            String regex = "^(199[0-9]),BEST PICTURE,True,(.*)$";
            Pattern pattern = Pattern.compile(regex);

            stream
                   .map(line -> {
                        Matcher matcher = pattern.matcher(line);
                        if (matcher.find()) {
                            return matcher.group(2); // recupera el nombre de la peli de la década de los 90's, ganadora del premio a "Best Picture"
                        } else {
                            return null;
                        }
                    })
                    .filter(Objects::nonNull)
                    .forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

}

