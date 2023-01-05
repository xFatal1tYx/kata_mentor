import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// Если попытаться создать существующий файл, выбросится исключение FileAlreadyExistsException
public class Main {
    public static void main(String... args) throws IOException {

        // Создание файла в текущей директории проекта
        Path file = Path.of("1.txt");
        if (!Files.exists(file)) {
            Files.createFile(file);
        }

        // Создание файла по абсолютному пути
        Path file2 = Path.of("C:", "2.txt");
        if (!Files.exists(file2)) {
            Files.createFile(file2);
        }

        // Создание файла по относительному пути, с использованием устаревшего метода Paths.get()
        Path file3 = Paths.get("src\\3.txt");
        if (!Files.exists(file3)) {
            Files.createFile(file3);
        }

    }
}
