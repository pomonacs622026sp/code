import java.util.Arrays;

public class InsertionSort {

    public static <E extends Comparable<E>> void insertionSort(E[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j].compareTo(a[j - 1]) < 0) {
                    E temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    public static <E extends Comparable<E>> void insertionSortAlternative(E[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            E current = a[i];
            int j = i - 1;

            while (j > 0 && current.compareTo(a[j]) < 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j] = current;
        }

    }

    public static void main(String[] args) {
        String[] array1 = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println(Arrays.toString(array1));
        insertionSort(array1);
        System.out.println(Arrays.toString(array1));
        String[] array2 = { "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E" };
        System.out.println(Arrays.toString(array2));
        insertionSort(array2);
        System.out.println(Arrays.toString(array2));

    }
}