// В сигнатуре метода в throws можно указать непроверяемое исключение, но обычно в этом нету смысла
public class Main {
    public static void main(String... args) throws ArrayIndexOutOfBoundsException {
        int[] a = new int[5];
        a[6] = 100;
    }
}
