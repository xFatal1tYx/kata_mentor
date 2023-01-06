import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class Main {

    public static void main(String... args) throws IOException {
        byte[] bytes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        InputStream input = new ByteArrayInputStream(bytes);
        
        // Вывод: 1
        System.out.println(input.read());

        bytes = new byte[3];
        // Вывод: 3 (3 байт было считано и записано в массив)
        System.out.println(input.read(bytes));
        // Вывод: [2, 3, 4]
        System.out.println(Arrays.toString(bytes));

        bytes = new byte[7];
        // Вывод: 5 (5 байт было считано и записано в массив со второго элемента)
        System.out.println(input.read(bytes, 2, 5));
        // Вывод: [0, 0, 5, 6, 7, 8, 9]
        System.out.println(Arrays.toString(bytes));
    }

}
