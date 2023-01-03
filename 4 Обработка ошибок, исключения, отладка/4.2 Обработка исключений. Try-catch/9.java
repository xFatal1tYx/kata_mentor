// В блоке try-with-resource можно открыть несколько ресурсов, через точку с запятой
// Вывод: resource is opened
// resource is opened

import java.io.Closeable;

class Test implements Closeable {
    @Override
    public void close() {
        System.out.println("resource is opened");
    }
}

public class Main {
    public static void main(String... args) {
        try (Test test = new Test(); Test test2 = new Test()) {
            //some code
        }
    }
}
