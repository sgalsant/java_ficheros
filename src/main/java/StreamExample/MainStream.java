package StreamExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.SocketHandler;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainStream {
    public static void main(String[] args) {
        System.out.println("Bienvenido a un nuevo mundo");

        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "product 1", 100));
        products.add(new Product(2, "product 2", 200));
        products.add(new Product(3, "product 3", 300));

        // ejemplo 1: obtener una lista con los nombres de los productos cuyo precio sea igual o superior a 200
        List<String> names = products.stream()
                .filter(p -> p.getPrice() >= 200)
                .map(Product::getName)
                .toList();

        names.forEach(System.out::println);

        // ejemplo 2: mostrar los primeros 20 números impares divisibles por 3 y no por 5
        /*
        IntStream
                .iterate(1, n -> n + 2)
                .filter(n -> n % 3 == 0 && n % 5 != 0)
                .limit(20)
                .forEach(System.out::println);
        */

        // ejemplo 3: sumar los primeros 20 números impares divisibles por 3 y no por 5
        /*
        int result = IntStream
                .iterate(1, n -> n + 2)
                .filter(n -> n % 3 == 0 && n % 5 != 0)
                .limit(20)
                .reduce(0, Integer::sum);
        */

        // ejemplo 4: toma una cadena de palabras separadas por coma y elimina las palabras distintas
        /*
        String text = "hello,world,stream,hello,forever";
        String text2 = Arrays.stream(text.split(",")).distinct().collect(Collectors.joining(","));
        System.out.println("text2: " + text2);
        */
    }
}
