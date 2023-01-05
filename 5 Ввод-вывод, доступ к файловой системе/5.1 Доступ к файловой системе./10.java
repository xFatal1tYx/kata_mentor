import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

// Если попытаться создать существующую директорию, выбросится исключение FileAlreadyExistsException
public class Main {
    public static void main(String... args) throws IOException {

        // Создание одной папки
        Path file = Path.of("C:\\123");
        if (!Files.exists(file)) {
            Files.createDirectory(file);
        }

        // Создание нескольких папок
        Path file2 = Path.of("C:\\456\\789");
        if (!Files.exists(file2)) {
            Files.createDirectories(file2);
        }

    }
}
