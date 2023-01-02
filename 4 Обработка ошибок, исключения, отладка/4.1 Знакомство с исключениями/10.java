public static void main(String... args) {
        
        RuntimeException someException = new RuntimeException("exception");
        
        // бросаем НЕ новое исключение
        throw someException;

        // бросаем новое исключение
        throw new NullPointerException("Something went wrong");
        
}
