import java.io.File;

public class Main {
    public static void main(String... args) {

        // Создание одной папки
        File file = new File("C:\\123");
        file.mkdir();

        // Создание нескольких папок
        File file2 = new File("C:\\456\\789");
        file2.mkdirs();

    }
}
