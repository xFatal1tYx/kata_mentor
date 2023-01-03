public class Main {
    public static void main(String... args)  {

        // Тут программа аварийно завершится
        // Вывод: something went wrong x2 (первое исключение подавляется)
        try {
            throw new RuntimeException("something went wrong");
        } catch (RuntimeException e) {
            throw new RuntimeException("something went wrong x2");
        }

        // А в этом случае будут обработаны все исключения и даже выведется finally блок
        // Вывод: something went wrong
        // something went wrong x2
        // finally block
        try {
            throw new RuntimeException("something went wrong");
        } catch (RuntimeException e) {
            try {
                throw new RuntimeException("something went wrong x2");
            } catch (RuntimeException r) {
                System.err.println(e.getMessage());
                System.err.println(r.getMessage());
            } finally {
                System.out.println("finally block");
            }
        }
    }
}
