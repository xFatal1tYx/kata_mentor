import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String... args) throws IOException {

        // Создание файла в текущей директории проекта
        File file = new File("1.txt");
        file.createNewFile();

        // Создание файла по абсолютному пути, важно указывать двойной слеш (экранирование символов)
        File file2 = new File("C:\\2.txt");
        file2.createNewFile();

        // Создание файла по относительному пути.
        // File.separator автоматически вставит нужный разделитель, в зависимости от файловой системы.
        File file3 = new File("src" + File.separator + "3.txt");
        file3.createNewFile();

    }
}
