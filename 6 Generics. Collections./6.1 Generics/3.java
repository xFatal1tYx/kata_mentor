/*
 * Параметризовать можно: классы, интерфейсы (в т.ч. вложенные),
 * конструкторы, поля объекта,
 * методы (возвращаемое значение и параметры),
 * статические классы и методы (но их тип должен отличаться от типа класса)
 */

class SomeClass<T> {

    private T value;

    SomeClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static <V> void printObj(V v) {
        System.out.println(v);
    }

}

interface JustInterface<T> {

}
