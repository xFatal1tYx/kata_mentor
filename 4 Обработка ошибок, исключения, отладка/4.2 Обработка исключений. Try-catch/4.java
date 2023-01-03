// Вывод: Exception in thread "main" java.io.IOException: exception from close() и аварийное завершение программы.

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
            //some code
        }
      
        System.out.println("bla-bla");
    }
}
