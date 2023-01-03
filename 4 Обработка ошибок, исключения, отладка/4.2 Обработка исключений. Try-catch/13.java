// Второе исключение полностью перекроет (затрёт) первое.
// Вывод: Exception in thread "main" java.lang.RuntimeException: something went wrong x2

public class Main {
    public static void main(String... args)  {
        try {
            throw new RuntimeException("something went wrong");
        } finally {
            throw new RuntimeException("something went wrong x2");
        }
    }
}
