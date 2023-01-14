/*
 * Вывод:
 * 30
 * abcdef
 * 50.5
 */

@FunctionalInterface
interface MyFunc<T> {
    T func(T v1, T v2);
}

public class Main {

    public static <T> void testFunc(MyFunc<T> f, T v1, T v2) {
        System.out.println(f.func(v1, v2));
    }

    public static void main(String[] args) {

        // Вызов метода с использованием анонимного класса
        testFunc(new MyFunc<>() {
            @Override
            public Integer func(Integer v1, Integer v2) {
                return v1 + v2;
            }
        }, 15, 15);

        // Вызов метода с использованием лямбда-выражения
        testFunc((x, y) -> x + y, "abc", "def");

        // Вызов метода с использованием ссылки на метод
        testFunc(Float::sum, 15f, 35.5f);

    }
}
