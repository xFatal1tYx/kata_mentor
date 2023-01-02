import java.io.IOException;

/*
 * main, как и любой другой метод может выбросить исключение.
 * Но если в данном контексте он является точкой запуска программы, то исключение будет обработано В JVM, интерфейсом UncaughtExceptionHandler.
 * Это стандартный интерфейс для обработчиков, вызываемых, когда поток внезапно завершается из-за неперехваченного исключения.
 */
public class Main {
    public static void main(String... args) throws IOException {
        throw new IOException("Something went wrong");
    }
}
