import java.net.URL;

public class Util {
    public String getPathResourceFile(String file) {
        URL resource = getClass().getClassLoader().getResource(file);
        if (resource == null) {
            System.out.println("fichero no existe: " + file);
            return null;
        }

        return resource.getPath();
    }
}
