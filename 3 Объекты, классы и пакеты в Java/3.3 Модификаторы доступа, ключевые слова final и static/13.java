// Нестатические методы могут перегрузить статические, но это будет два разных метода. Статический будет принадлежать, а нестатический объекту.
public class Main  {
    public static void justMethod() {
        System.out.println("static method");
    }

    public void justMethod(String a) {
        System.out.println(a);
    }

    public static void main(String[] args) {
        Main.justMethod(); // static method
        Main main = new Main();
        main.justMethod("method"); // method
    }

}
