import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {

    public static void main(String... args) throws IOException {

        // Удаление через класс File. result = false
        File notEmptyFolder = new File("C:\\123");
        boolean result = notEmptyFolder.delete();

        // Преобразование File в Path
        Path notEmptyDirectory = notEmptyFolder.toPath();

        // Удаление через класс Files. Exception: DirectoryNotEmptyException
        Files.deleteIfExists(notEmptyDirectory);

        // Удаление с помощью перебора через стрим и метода Files.walk()
        deleteByStream(notEmptyDirectory);

        // Удаление с помощью класса SimpleFileVisitor и метода Files.walkFileTree()
        deleteByWalkFileTree(notEmptyDirectory);
        
    }

    public static void deleteByWalkFileTree(Path notEmptyDirectory) throws IOException {
        Files.walkFileTree(notEmptyDirectory, new SimpleFileVisitor<>() {
                    // Вложенный класс SimpleFileVisitor

                    // Удаление вложенных файлов
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file);
                        return FileVisitResult.CONTINUE;
                    }

                    // Удаление родительской директории
                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir);
                        return FileVisitResult.CONTINUE;
                    }
                }
        );
    }

    public static void deleteByStream(Path notEmptyDirectory) throws IOException {
        if (!Files.exists(notEmptyDirectory)) {
            return;
        }

        // Обратная сортировка позволяет сначала удалить все вложенные файлы
        try (Stream<Path> files = Files.walk(notEmptyDirectory).sorted(Comparator.reverseOrder())) {
            files.forEach(file -> {
                try {
                    Files.delete(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
    
}
