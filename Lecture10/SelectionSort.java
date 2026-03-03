import java.util.Arrays;

public class SelectionSort {
    public static <E extends Comparable<E>> void selectionSort(E[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            E temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }



    public static void main(String[] args) {
        String[] array1 = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println(Arrays.toString(array1));
        selectionSort(array1);
        System.out.println(Arrays.toString(array1));
    }
}