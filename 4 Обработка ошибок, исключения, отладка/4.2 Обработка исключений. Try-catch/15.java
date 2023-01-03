// Вывод: Exception in thread "main" java.io.IOException: exception from main()
// Suppressed: java.io.IOException: exception from close()
// Таким образом, исключение метода close() было подавлено

import java.io.IOException;

class Test implements AutoCloseable {
    @Override
    public void close() throws IOException {
        throw new IOException("exception from close()");
    }
}

public class Main {
    public static void main(String... args) throws IOException {
        try (Test test = new Test()) {
            throw new IOException("exception from main()");
        }
    }
}
