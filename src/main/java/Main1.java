import java.io.FileInputStream;
import java.io.InputStream;


public class Main1 {
    /**
     * Leer un fichero de texto letra a letra. Poco eficiente al realizar la lectura letra a letra y además, no se
     * puede indicar que charset se está usando, con lo que tendremos problema al leer archivos en UTF-8 que incluya ñ, acentos...
     * @param args
     */
    public static void main(String[] args) {
        String fileName = new Util().getPathResourceFile("oscars.csv");
        if (fileName == null) return;

        try (InputStream inputStream = new FileInputStream(fileName);) {
            int c;
            while ((c = inputStream.read()) != -1) {
                System.out.print((char)c);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
