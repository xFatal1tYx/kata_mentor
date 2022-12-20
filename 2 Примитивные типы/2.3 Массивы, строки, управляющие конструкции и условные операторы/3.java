public class Main {

    public static void main(String[] args) {

        //Многомерные массивы в Java эмулируются через вложенные одномерные массивы
        //Это позволяет иметь ступенчатые массивы (строки могут отличаться по длине).

        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = {{1, 2}, {3, 4}};
        int[] firstRow = matrix2[0];
        int someElement = matrix2[1][1];

    }

}
