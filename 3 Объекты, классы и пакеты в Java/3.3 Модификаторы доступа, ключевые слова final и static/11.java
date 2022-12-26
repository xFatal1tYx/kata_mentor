// Переопределить static метод не получится, на такие методы можно намеренно скрыть (hiding), назвав его таким же именем и задав static.
// Тогда компилятор будет вызывать новый метод.
public class Main  {

    public static void justMethod() {
        System.out.println("first method");
    }

    // Статические методы могут быть перегружены, как и любой другой метод
    public static void justMethod(String a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        Test.justMethod(); // first method
        Test2.justMethod(); // second method
    }
}

class Test extends Main { }

class Test2 extends Main {
    public static void justMethod() {
        System.out.println("second method");
    }
}
