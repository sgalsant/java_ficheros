import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main4 {
    /**
     * Leer todo el contenido del fichero en una única operación. Más rápido al realizar una única operación
     * I/O sobre disco pero puede consumir mucha memoria RAM si el fichero es demasiado grande.
     * Observa que la clase "Files" pertenece al nuevo paquete "java.nio".
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        try {
            String content = Files.readString(Path.of(fileName), StandardCharsets.UTF_8);
            System.out.println(content);

            // también tenemos la posibilidad de cargar una List donde cada elemento es una línea del archivo
            // List<String> allLines = Files.readAllLines(Path.of(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
