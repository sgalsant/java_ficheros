import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class Main3 {
    /**
     * Incluimos el uso de un buffer que permite leer de una vez tantos bytes como se indique en su tamaño, reduciendo
     * el número de operaciones de I/O al disco duro para leer el fichero
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        final int BUFFER_SIZE = 1024;

        long start = System.nanoTime();

        try (InputStream inputStream = new FileInputStream(fileName);
             BufferedInputStream buffer = new BufferedInputStream(inputStream, BUFFER_SIZE);
             InputStreamReader reader = new InputStreamReader(buffer, StandardCharsets.UTF_8);) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        long end = System.nanoTime();
        System.out.println("duración: " + TimeUnit.NANOSECONDS.toMillis(end -start));
    }
}
