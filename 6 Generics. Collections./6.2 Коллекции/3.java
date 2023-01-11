/*
 * Вставка элементов ArrayList vs LinkedList.
 *
 * В начало:
 * ArrayList немного быстрее, если мало элементов (до 3000)
 * В остальных случаях LinkedList гораздо быстрее (пропорционально количеству элементов)
 *
 * В середину:
 * ArrayList всегда значительно быстрее (пропорционально количеству элементов)
 *
 * В конец:
 * Скорость обоих массивов примерно равна, но ArrayList чаще выйгрывает при большом количестве элементов.
 *
 */

import java.io.IOException;
import java.text.NumberFormat;
import java.util.*;


public class Main {
    public static NumberFormat numberFormat = NumberFormat.getInstance();

    public enum Insertion {
        START("начало"), MIDDLE("середину"), END("конец");

        private final String name;

        Insertion(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    public static void countTime(List<Integer> list, int count, Insertion insertion) {
        long time = System.nanoTime();

        for (int i = 0; i < count; i++) {
            if (insertion == Insertion.START) {
                list.add(0, i);
            } else if (insertion == Insertion.MIDDLE) {
                list.add(list.size() / 2, i);
            } else {
                list.add(i);
            }
        }

        time = System.nanoTime() -  time;
        System.out.printf("%s: добавление %d элементов в %s: %s nano seconds\n",
                list.getClass().getSimpleName(),
                count,
                insertion,
                numberFormat.format(time));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Подготовим JVM к тестам :)");
        countTime(new ArrayList<>(), 1000, Insertion.START);
        System.out.println("\n");

        countTime(new ArrayList<>(), 1000, Insertion.START);
        countTime(new LinkedList<>(), 1000, Insertion.START);
        countTime(new ArrayList<>(), 5000, Insertion.START);
        countTime(new LinkedList<>(), 5000, Insertion.START);
        countTime(new ArrayList<>(), 50000, Insertion.START);
        countTime(new LinkedList<>(), 50000, Insertion.START);
        System.out.println("\n");

        countTime(new ArrayList<>(), 1000, Insertion.MIDDLE);
        countTime(new LinkedList<>(), 1000, Insertion.MIDDLE);
        countTime(new ArrayList<>(), 5000, Insertion.MIDDLE);
        countTime(new LinkedList<>(), 5000, Insertion.MIDDLE);
        countTime(new ArrayList<>(), 50000, Insertion.MIDDLE);
        countTime(new LinkedList<>(), 50000, Insertion.MIDDLE);
        System.out.println("\n");

        countTime(new ArrayList<>(), 1000, Insertion.END);
        countTime(new LinkedList<>(), 1000, Insertion.END);
        countTime(new ArrayList<>(), 5000, Insertion.END);
        countTime(new LinkedList<>(), 5000, Insertion.END);
        countTime(new ArrayList<>(), 50000, Insertion.END);
        countTime(new LinkedList<>(), 50000, Insertion.END);
    }
}
