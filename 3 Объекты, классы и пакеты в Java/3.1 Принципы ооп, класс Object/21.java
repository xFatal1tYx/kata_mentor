import java.util.Arrays;

public class Main {

    // Значения изменятся, ведь мы передаём копию ссылки, по которой легко можно изменить состояние объекта
    static void changeArray(int[] array) {
        array[0] += 10;
        array[1] += 10;
        array[2] += 10;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        changeArray(array);

        // Вывод 11, 12, 13
        System.out.println(Arrays.toString(array));
    }
    
}
