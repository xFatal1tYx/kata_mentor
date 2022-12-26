// Нестатические методы НЕ могут перегрузить статические, будет два разных метода. Статический будет принадлежать классу и будет доступен через его имя.
// А нестатический будет принадлежать конкретному объекту и доступен через вызов метода этого объекта.
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
