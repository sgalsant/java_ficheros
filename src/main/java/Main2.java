import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class Main2 {
    /**
     * Solucionamos el problema de indicar el Charset usando "InputStreamReader". Pero sigue siendo poco eficiente porque se sigue
     * leyendo caracter a caracter
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        try (InputStream inputStream = new FileInputStream(fileName);
            InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

