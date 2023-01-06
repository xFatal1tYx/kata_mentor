import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
 * Вывод 1 2 3 255 2
 * -1 в двоичной системе выглядит как (...1111)11111111
 * Метод read() возвращает int и убирает старшие единицы в двоичном представлении
 * Получаем 11111111(2) = 255(10)
 */
public class Main {

    public static void main(String... args) throws IOException {
        byte[] bytes = {1, 2, 3, -1, 2};
        InputStream input = new ByteArrayInputStream(bytes);

        int value;
        while ((value = input.read()) != -1) {
            System.out.println(value);
        }
    }

}
