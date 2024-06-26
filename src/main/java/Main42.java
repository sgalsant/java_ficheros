import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class Main42 {
    /**
     * Leer el contenido del archivo línea a línea
     * Observa que la clase "Files" pertenece al nuevo paquete "java.nio".
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
           String line;
           while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length > 2 &&
                        fields[1].equalsIgnoreCase("BEST PICTURE") &&
                        fields[2].equalsIgnoreCase("True")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
