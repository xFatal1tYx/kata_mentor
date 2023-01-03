// Вывод: exception from close()
// bla-bla

import java.io.Closeable;
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
        } catch (IOException e) {
            System.out.println(e);
        }
      
        System.out.println("bla-bla");
    }
}
